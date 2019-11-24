package com.semako.asksa.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.semako.asksa.R;

public class FormClientpmActivity extends AppCompatActivity {

   // Initialisation des variables
    private EditText etRaison, etIfu, etTelephone, etEmail, etAdresse;
    private Button btValider, btAnnuler;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_clientpm);

        //Assignation des variables
        etRaison    =   findViewById(R.id.et_raison);
        etIfu       =   findViewById(R.id.et_ifu);
        etTelephone =   findViewById(R.id.et_telephone);
        etEmail     =   findViewById(R.id.et_email);
        etAdresse   =   findViewById(R.id.et_adresse);
        btValider   =   findViewById(R.id.bt_valider);
        btAnnuler   =   findViewById(R.id.bt_annuler);

        // Initialiser le style de validation

        awesomeValidation   =   new AwesomeValidation(ValidationStyle.BASIC);

        // Ajout de validation aux champs
        awesomeValidation.addValidation(this, R.id.et_raison,
                RegexTemplate.NOT_EMPTY,R.string.invalide_raison);
        awesomeValidation.addValidation(this,R.id.et_telephone,
                "[6-9]{2}[0-9]{6}$",R.string.invalide_phone);
        // Test de validation
        btValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()){
                    Toast.makeText(FormClientpmActivity.this, "Formulaire valide ....", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(FormClientpmActivity.this, "Formulaire invalide", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
