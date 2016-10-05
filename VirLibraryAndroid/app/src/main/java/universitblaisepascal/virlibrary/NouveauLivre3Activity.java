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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

public class NouveauLivre3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_livre3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button buttonAnnuler = (Button) findViewById(R.id.buttonAnnulerNouveauLivre3);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(NouveauLivre3Activity.this, MainActivity.class));
            }
        });

        Button buttonRetour = (Button) findViewById(R.id.buttonRetourNouveauLivre3);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = getIntent();
                Livre livre = (Livre) intent.getSerializableExtra("nouveauLivre3");

                livre = recupererInput(livre);
                intent = new Intent(NouveauLivre3Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button buttonValider = (Button) findViewById(R.id.buttonValiderNouveauLivre3);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = getIntent();
                Livre livre = (Livre) intent.getSerializableExtra("nouveauLivre2");

                livre = recupererInput(livre);
                intent = new Intent(NouveauLivre3Activity.this, MainActivity.class);

                AlertDialog alertDialog = new AlertDialog.Builder(NouveauLivre3Activity.this).create();
                alertDialog.setTitle("Résumé de l'ajout du livre");
                alertDialog.setMessage(livre.toString());
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            //startActivity(intent);
            }
        });
    }

    public void onStart(){
        super.onStart();
        EditText txtDate= (EditText) findViewById(R.id.inputDateAchatNouveauLivre);
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

    private Livre recupererInput(Livre livre) {
        EditText input;
        Switch pretable;
        input = (EditText)findViewById(R.id.inputNombreExemplaireNouveauLivre);
        livre.setNbExemplaire(Integer.parseInt(input.getText().toString()));
        input = (EditText)findViewById(R.id.inputDateAchatNouveauLivre);
        livre.setDateAchatExemplaire(input.getText().toString());
        input = (EditText)findViewById(R.id.inputEtatNouveauLivre);
        livre.setEtat(input.getText().toString());
        pretable = (Switch)findViewById(R.id.swtichPretableNouveauLivre);
        livre.setPretable(pretable.isChecked());

        return livre;
    }

}
