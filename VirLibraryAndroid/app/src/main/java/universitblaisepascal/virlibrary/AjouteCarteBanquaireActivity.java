package universitblaisepascal.virlibrary;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class AjouteCarteBanquaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Profil profil = (Profil) getApplicationContext();

        setContentView(R.layout.activity_ajoute_carte_banquaire);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Spinner spinner = (Spinner) findViewById(R.id.spinnerTypeCarteBanquaireAjoutCarte);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type_carte_banquaire, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinnerMois = (Spinner) findViewById(R.id.spinnerMoisAjoutCarte);
        ArrayAdapter<CharSequence> adapterMois = ArrayAdapter.createFromResource(this,
                R.array.mois_date_validite, android.R.layout.simple_spinner_item);
        adapterMois.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMois.setAdapter(adapterMois);

        Spinner spinnerAnnee = (Spinner) findViewById(R.id.spinnerAnneeAjoutCarte);
        ArrayAdapter<CharSequence> adapterAnnee = ArrayAdapter.createFromResource(this,
                R.array.annee_date_validite, android.R.layout.simple_spinner_item);
        adapterAnnee.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAnnee.setAdapter(adapterAnnee);


        Button ajoutCarte = (Button) findViewById(R.id.buttonAjoutCarte);
        ajoutCarte.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText numCarte = (EditText) findViewById(R.id.inputNumeroCarteAjoutCarteBanquaire);
                EditText proprio = (EditText) findViewById(R.id.inputProprioCarteBanquaireAjoutCarte);
                EditText codeSecu = (EditText) findViewById(R.id.inputCodeSecuriteAjoutCarte);
                Spinner typeCarte = (Spinner) findViewById(R.id.spinnerTypeCarteBanquaireAjoutCarte);
                Spinner mois = (Spinner) findViewById(R.id.spinnerMoisAjoutCarte);
                Spinner annee = (Spinner) findViewById(R.id.spinnerAnneeAjoutCarte);

                String numCarteString = numCarte.getText().toString();
                String proprietaire = proprio.getText().toString();
                String codeSecurite = codeSecu.getText().toString();
                String typeCarteBanque = typeCarte.getSelectedItem().toString();
                String date = mois.getSelectedItem().toString() +"/"+ annee.getSelectedItem().toString();

                if(!isNotEmpty(proprietaire)){
                    popup("Veuillez remplir le nom du propriétaire.", "Vous devez indiquez le nom du propriétaire de la carte afin de pouvoir l'ajouté.");
                }
                if(!isNotEmpty(typeCarteBanque)){
                    popup("Veuillez remplir le type de carte bancaire.", "Vous devez indiquez le type de votre carte bancaire afin de pouvoir l'ajouté.");
                }
                if(codeSecurite.length() != 3){
                    popup("Veuillez entrée un code de sécurité valide.", "Vous devez indiquez un code de sécurité valide afin de pouvoir ajouté votre carte.");
                }
                if(numCarteString.length() != 16){
                    popup("Veuillez entrée un numéro de carte valide.", "Vous devez indiquez un numéro de carte bancaire valide afin de pouvoir l\'ajouté.");
                }
                if(isNotEmpty(proprietaire) && isNotEmpty(typeCarteBanque) && numCarteString.length() == 16 && codeSecurite.length() == 3){
                    List<CarteBanquaire> carteBanquaireList = profil.getCoordBanquaire().getCarteBanquaire();
                    carteBanquaireList.add(new CarteBanquaire(typeCarteBanque, proprietaire, carteBanquaireList.size()+1, numCarteString, date, Integer.parseInt(codeSecurite)));
                    startActivity(new Intent(AjouteCarteBanquaireActivity.this, CoordBanquaireActivity.class));
                }
            }
        });

    }

    private void popup(String titre, String txt){
        AlertDialog alertDialog = new AlertDialog.Builder(AjouteCarteBanquaireActivity.this).create();
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
}

