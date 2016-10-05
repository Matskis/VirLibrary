package universitblaisepascal.virlibrary;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Inscription3Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Profil profil =(Profil) getApplicationContext();

        retourSauvegarde(profil);

        Button buttonAnnuler = (Button) findViewById(R.id.buttonAnnulerInscription3);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Inscription3Activity.this, MainActivity.class));
            }
        });

        Button buttonRetour = (Button) findViewById(R.id.buttonRetourInscription3);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent =  getIntent();
                Intent mIntent = new Intent(Inscription3Activity.this ,Inscription2Activity.class);
                startActivity(mIntent);
            }
        });

        Button buttonValider = (Button) findViewById(R.id.buttonValiderInscription);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                recupererInput(profil);
                Intent intent = new Intent(Inscription3Activity.this, MainActivity.class);

                String sexe = Character.toString(profil.getUSER_SEXE());

                if(!isNotEmpty(profil.getUSER_DATE_NAISSANCE().toString())){
                    popup("La date de naissance n\'est pas remplie.", "Vous n\'avez pas remplie votre date de naissance.");
                }
                if(!isNotEmpty(profil.getUSER_TELEPHONE())){
                    popup("Le numéro de téléphone n\'est pas remplie.", "Vous n\'avez pas remplie le champs du numéro de téléphone.");
                }
                if(profil.getUSER_TELEPHONE().length() !=10){
                    if(profil.getUSER_TELEPHONE().substring(0, 1) != "+" && profil.getUSER_TELEPHONE().length() != 12){
                        popup("Le numéro de téléphone donner n\'est pas correct.", "Vous n\'avez pas donner un numéro de téléphone valide.");
                    }
                }
                startActivity(intent);
            }
        });

        //liste déroulante pour le sexe
        Spinner spinner = (Spinner) findViewById(R.id.spinnerInscription3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sexe, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onStart(){
        super.onStart();
        EditText txtDate= (EditText) findViewById(R.id.inputDateNaissInscription);
        txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DateDialog dialog = new DateDialog(v);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "Calendrier");
                }
            }
        });
    }

    private void recupererInput(Profil profil) {
        EditText input;
        Spinner spinner;

        input = (EditText)findViewById(R.id.inputDateNaissInscription);
        profil.setUSER_DATE_NAISSANCE(input.getText().toString());
        input = (EditText)findViewById(R.id.inputTelephoneInscription);
        profil.setUSER_TELEPHONE(input.getText().toString());
        spinner = (Spinner)findViewById(R.id.spinnerInscription3);
        profil.setUSER_REPUTATION(0);
        profil.setUSER_STATUT("A");
        profil.setUSER_SEXE(spinner.getSelectedItem().toString().charAt(0));

        String format = "dd/MM/yy H:mm:ss";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        profil.setDATE_CREATION(date);

    }

    private Boolean isNotEmpty(String txt){
        Boolean test = false;
        if(txt.length()!=0){
            test = true;
        }
        else{
            test = false;
        }
        return test;
    }

    private void popup(String titre, String txt){
        AlertDialog alertDialog = new AlertDialog.Builder(Inscription3Activity.this).create();
        alertDialog.setTitle(titre);
        alertDialog.setMessage(txt);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void retourSauvegarde( Profil profil) {

        EditText output;
        Spinner spinner;

        output = (EditText)findViewById(R.id.inputDateNaissInscription);
        output.setText(profil.getUSER_DATE_NAISSANCE());
        output = (EditText)findViewById(R.id.inputTelephoneInscription);
        output.setText(profil.getUSER_TELEPHONE());
        spinner = (Spinner)findViewById(R.id.spinnerInscription3);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.sexe, android.R.layout.simple_spinner_item);

        spinner.setSelection(arrayAdapter.getPosition(String.valueOf(profil.getUSER_SEXE())));
    }
}
