package com.semako.asksa.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.semako.asksa.R;

public class FormClientppActivity extends AppCompatActivity {

    // Initialisation des variables

    private EditText etNom, etPrenom, etTelephone, etEmail, etAdresse;
    private Button btValider, btAnnuler;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_clientpp);

        // Assignation des variable
        etNom       =   findViewById(R.id.et_nom);
        etPrenom    =   findViewById(R.id.et_prenom);
        etTelephone =   findViewById(R.id.et_telephone);
        etEmail     =   findViewById(R.id.et_email);
        etAdresse   =   findViewById(R.id.et_adresse);
        btValider   =   findViewById(R.id.bt_valider);
        btAnnuler   =   findViewById(R.id.bt_annuler);

        // initialisation de style de Validation
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        // Ajout de validation aux champs
        awesomeValidation.addValidation(this,R.id.et_nom,
                RegexTemplate.NOT_EMPTY,R.string.ivalide_nom);
        /*awesomeValidation.addValidation(this,R.id.et_email,
                Patterns.EMAIL_ADDRESS,R.string.invalide_email);*/
        awesomeValidation.addValidation(this,R.id.et_telephone,
                "[6-9]{2}[0-9]{6}$",R.string.invalide_phone);

        btValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Verification de validation
                if (awesomeValidation.validate()){
                    // succes
                    Toast.makeText(FormClientppActivity.this,
                            "Formulaire validé avec succès", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(FormClientppActivity.this, "Formulaire Invalide", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
