package universitblaisepascal.virlibrary;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NouveauLivreActivity extends AppCompatActivity {

    public static Livre livre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_livre);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button buttonSuivant = (Button) findViewById(R.id.buttonSuivantNouveauLivre);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            Intent intent = new Intent(NouveauLivreActivity.this, NouveauLivre2Activity.class);
            livre = recuperInput();
            intent.putExtra("nouveauLivre1", livre);
            startActivity(intent);
            }
        });

        Button buttonAnnuler = (Button) findViewById(R.id.buttonAnnulerNouveauLivre);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(NouveauLivreActivity.this, MainActivity.class));
            }
        });
    }

    public void onStart(){
        super.onStart();
        EditText txtDate= (EditText) findViewById(R.id.inputDateParutionNouveauLivre);
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

    private Livre recuperInput(){
        EditText input;
        input = (EditText)findViewById(R.id.inputTitreNouveauLivre);
        String titre = input.getText().toString();
        input = (EditText)findViewById(R.id.inputDateParutionNouveauLivre);
        String dateParution = input.getText().toString();
        input = (EditText)findViewById(R.id.inputLangueNouveauLivre);
        String langue = input.getText().toString();
        input = (EditText)findViewById(R.id.inputEditionNouveauLivre);
        String edition = input.getText().toString();
        input = (EditText)findViewById(R.id.inputResumeNouveauLivre);
        String resume = input.getText().toString();
        input = (EditText)findViewById(R.id.inputPrixNouveauLivre);
        String prix = input.getText().toString();
        input = (EditText)findViewById(R.id.inputDeviseNouveauLivre);
        String devise = input.getText().toString();
        input = (EditText)findViewById(R.id.inputAuteurInscription);
        String auteur = input.getText().toString();
        livre = new Livre(prix, titre, langue, edition, resume, auteur);
        livre.setDateParution(dateParution);
        livre.setDevise(devise);
        return livre;
    }

}
