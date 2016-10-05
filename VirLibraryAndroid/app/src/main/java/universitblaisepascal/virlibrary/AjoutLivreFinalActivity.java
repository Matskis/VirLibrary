package universitblaisepascal.virlibrary;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class AjoutLivreFinalActivity extends AppCompatActivity {
    ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_livre_final);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Profil profil = (Profil) getApplicationContext();
        final Livre livre;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        livre = (Livre) intent.getSerializableExtra("vueLivre");

        TextView titre = (TextView)findViewById(R.id.titre_commentaire_vue_livre_fragment);
        titre.setText(livre.getTitre() + " " + livre.getAuteur());
        TextView isbn = (TextView)findViewById(R.id.isbn_livre_fragment);
        isbn.setText("ISBN : " + livre.getISBN());
        TextView prix = (TextView)findViewById(R.id.txtPrixAjoutLivreFinal);
        String  prixS= "";
        if(livre.getPrix() != null){prixS = livre.getPrix() + " "+ livre.getDevise();}
        prix.setText(prixS);
        TextView edition = (TextView)findViewById(R.id.edition_livre_fragment);
        edition.setText(livre.getEdition());
        TextView dateEdition = (TextView)findViewById(R.id.date_edition_livre_fragment);
        dateEdition.setText(livre.getDateEdition());
        TextView resume = (TextView)findViewById(R.id.resume_livre_fragment);
        resume.setText(livre.getResume());
        TextView langue = (TextView)findViewById(R.id.langue_livre_fragment);
        langue.setText(livre.getLangue());

        Button finalAjout = (Button) findViewById(R.id.buttonAjoutLivreAjoutLivreFinal);
        finalAjout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText txtDate= (EditText) findViewById(R.id.inputDateAchatLivreAjoutLivreFinal);
                Switch empruntable = (Switch) findViewById(R.id.switchEmpruntVueLivre);
                EditText etat = (EditText) findViewById(R.id.inputEtatLivreAjoutLivreFinal);
                EditText nbExemplaire = (EditText) findViewById(R.id.inputNbExemplaireAjoutLivreFinal);
                livre.setDateAchatExemplaire(txtDate.getText().toString());
                livre.setPretable(empruntable.isChecked());
                livre.setEtat(etat.getText().toString());
                livre.setNbExemplaire(Integer.parseInt(nbExemplaire.getText().toString()));

                profil.ajouteLivre(livre);
                startActivity(new Intent(AjoutLivreFinalActivity.this, MainActivity.class));
            }
        });

    }

    public void onStart(){
        super.onStart();
        EditText txtDate= (EditText) findViewById(R.id.inputDateAchatLivreAjoutLivreFinal);
        txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DateDialog dialog = new DateDialog(v);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "Date d'achat du livre");
                }
            }
        });
    }

    private void popup(String titre, String txt){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
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
