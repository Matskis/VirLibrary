package universitblaisepascal.virlibrary;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Inscription2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Profil profil =(Profil) getApplicationContext();

        retourSauvegarde(profil);

        Button buttonSuivant = (Button) findViewById(R.id.buttonSuivantInscription2);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                recupererInput(profil);

                if(!isNotEmpty(profil.getAdresse().getADRESSE_LIGNE1())){
                    popup("L\'adresse n\'est pas remplie.", "Vous n\'avez pas remplie le champs adresse.");
                }

                if(!isNotEmpty(profil.getAdresse().getCODE_POSTAL())){
                    popup("Le code postale n\'est pas remplie.", "Vous n\'avez pas remplie le champs concernant le code postale.");
                }

                if(profil.getAdresse().getCODE_POSTAL().length()>=3 && profil.getAdresse().getCODE_POSTAL().length()<=9){
                    popup("Le code postale n\'est pas correct.", "Le champs concernant le code postale est invalide.");
                }

                if(!isNotEmpty(profil.getAdresse().getVILLE())){
                    popup("La ville n\'est pas remplie.", "Vous n\'avez pas remplie le champs concernant la ville.");
                }

                if(!isNotEmpty(profil.getAdresse().getPAYS())){
                    popup("Le pays n\'est pas remplie.", "Vous n\'avez pas remplie le champs concernant le pays.");
                }

                if(isNotEmpty(profil.getAdresse().getADRESSE_LIGNE1()) && isNotEmpty(profil.getAdresse().getCODE_POSTAL()) && isNotEmpty(profil.getAdresse().getPAYS())){
                    Intent intent = new Intent(Inscription2Activity.this, Inscription3Activity.class);
                    startActivity(intent);
                }

            }
        });

        Button buttonAnnuler = (Button) findViewById(R.id.buttonAnnulerInscription2);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Inscription2Activity.this, MainActivity.class));
            }
        });

        Button buttonRetour = (Button) findViewById(R.id.buttonRetourInscription2);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                recupererInput(profil);
                Intent mIntent = new Intent(Inscription2Activity.this ,InscriptionActivity.class);
                startActivity(mIntent);
            }
        });

        //liste déroulante pour le pays
        Spinner spinner = (Spinner) findViewById(R.id.inputPaysInscription);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(71);

    }

    private void recupererInput(Profil profil) {

        Spinner spinner;
        EditText input;
        input = (EditText)findViewById(R.id.inputAdresseInscription);
        String adresse = input.getText().toString();
        input = (EditText)findViewById(R.id.inputAdresse2Inscription);
        String adresse2 = input.getText().toString();
        input = (EditText)findViewById(R.id.inputCpInscription);
        String cp = input.getText().toString();
        input = (EditText)findViewById(R.id.inputVilleInscription);
        String ville = input.getText().toString();
        spinner = (Spinner)findViewById(R.id.inputPaysInscription);
        String pays = spinner.getSelectedItem().toString();


            profil.getAdressePrincipal().setADRESSE_LIGNE1(adresse);
            profil.getAdressePrincipal().setADRESSE_LIGNE2(adresse2);
            profil.getAdressePrincipal().setCODE_POSTAL(cp);
            profil.getAdressePrincipal().setVILLE(ville);
            profil.getAdressePrincipal().setPAYS(pays);

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

        AlertDialog alertDialog = new AlertDialog.Builder(Inscription2Activity.this).create();
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

        Spinner spinner;
        EditText output;
        output = (EditText)findViewById(R.id.inputAdresseInscription);
        output.setText(profil.getAdressePrincipal().getADRESSE_LIGNE1());
        output = (EditText)findViewById(R.id.inputAdresse2Inscription);
        output.setText(profil.getAdressePrincipal().getADRESSE_LIGNE2());
        output = (EditText)findViewById(R.id.inputCpInscription);
        output.setText(profil.getAdressePrincipal().getCODE_POSTAL());
        output = (EditText)findViewById(R.id.inputVilleInscription);
        output.setText(profil.getAdressePrincipal().getVILLE());
        spinner = (Spinner)findViewById(R.id.inputPaysInscription);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.pays, android.R.layout.simple_spinner_item);

        spinner.setSelection(arrayAdapter.getPosition(String.valueOf(profil.getAdressePrincipal().getPAYS())));


    }

}
