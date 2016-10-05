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

public class NouveauLivre2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_livre2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button buttonAnnuler = (Button) findViewById(R.id.buttonAnnulerNouveauLivre2);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(NouveauLivre2Activity.this, MainActivity.class));
            }
        });

        Button buttonRetour = (Button) findViewById(R.id.buttonRetourNouveauLivre2);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(NouveauLivre2Activity.this, NouveauLivreActivity.class));
            }
        });

        Button buttonSuivant = (Button) findViewById(R.id.buttonSuivantNouveauLivre2);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = getIntent();
                Livre livre = (Livre) intent.getSerializableExtra("nouveauLivre1");

                livre = recupererInput(livre);
                intent = new Intent(NouveauLivre2Activity.this, NouveauLivre3Activity.class);
                intent.putExtra("nouveauLivre2", livre);
                startActivity(intent);
            }
        });
    }

    private Livre recupererInput(Livre livre){
        EditText input;
        input = (EditText)findViewById(R.id.inputIsbnNouveauLivre);
        livre.setISBN(input.getText().toString());
        input = (EditText)findViewById(R.id.inputDateEditionNouveauLivre);
        livre.setDateEdition(input.getText().toString());
        input = (EditText)findViewById(R.id.inputNomEditeurNouveauLivre);
        livre.setNomEditeur(input.getText().toString());
        input = (EditText)findViewById(R.id.inputPaysEditeurNouveauLivre);
        livre.setPaysEditeur(input.getText().toString());
        return livre;
    }
}
