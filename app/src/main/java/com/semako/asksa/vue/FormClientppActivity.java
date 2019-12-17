package com.semako.asksa.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.semako.asksa.MyDao;
import com.semako.asksa.MyDatabase;
import com.semako.asksa.R;
import com.semako.asksa.modele.Categorie;

import java.util.List;

public class FormClientppActivity extends AppCompatActivity {

    // Initialisation des variables

    public static MyDao myDao;

    private EditText etNom, etPrenom, etTelephone, etEmail, etAdresse;
    private Button btValider, btAnnuler;
    private Spinner spinner;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_clientpp);
        initialisation();





    }

    public void initialisation(){
        // Assignation des variable
        etNom       =   findViewById(R.id.et_nom);
        etPrenom    =   findViewById(R.id.et_prenom);
        etTelephone =   findViewById(R.id.et_telephone);
        etEmail     =   findViewById(R.id.et_email);
        etAdresse   =   findViewById(R.id.et_adresse);
        btAnnuler   =   findViewById(R.id.bt_annuler);
        spinner     =   findViewById(R.id.sp_categorie);

        List<Categorie> categorieList;

    }

    public void btValider(View view) {

        // initialisation de style de Validation
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        // Ajout de validation aux champs
        awesomeValidation.addValidation(this,R.id.et_nom,
                RegexTemplate.NOT_EMPTY,R.string.ivalide_nom);
                /*awesomeValidation.addValidation(this,R.id.et_email,
                        Patterns.EMAIL_ADDRESS,R.string.invalide_email);*/
        awesomeValidation.addValidation(this,R.id.et_telephone,
                "[6-9]{2}[0-9]{6}$",R.string.invalide_phone);


        //Verification de validation
        if (awesomeValidation.validate()){
            // succes
            Toast.makeText(FormClientppActivity.this,
                    "Formulaire validé avec succès", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(FormClientppActivity.this, "Formulaire Invalide",
                    Toast.LENGTH_SHORT).show();
        }

    }

    private void lordCategorie(List<Categorie> categorieList){

    }

    private class FindAllCategories extends AsyncTask<String, Void, Void>{
        List<Categorie> categorieList;

        @Override
        protected Void doInBackground(String... strings) {
            categorieList = myDao.findAllCategories();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (categorieList == null){
                Toast.makeText(FormClientppActivity.this, "Changement catégorie echoué",
                        Toast.LENGTH_SHORT).show();
            }else {

                lordCategorie(categorieList);
            }
        }
    }

}
