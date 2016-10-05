package universitblaisepascal.virlibrary;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class AjoutLivreActivity extends AppCompatActivity {
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_livre);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final TextView titreChoixTitre = (TextView) findViewById(R.id.textViewTrouverTitreTitle);
        titreChoixTitre.setVisibility(View.INVISIBLE);
        final TextView titreChoixIsbn = (TextView) findViewById(R.id.textViewTrouverIsbnTitle);
        titreChoixIsbn.setVisibility(View.INVISIBLE);
        final EditText inputIsbn = (EditText) findViewById(R.id.inputIsbnAjoutLivre);
        inputIsbn.setVisibility(View.INVISIBLE);
        final EditText inputTitre = (EditText) findViewById(R.id.inputTitreAjoutLivre);
        inputTitre.setVisibility(View.INVISIBLE);
        final Button rechercher = (Button) findViewById(R.id.buttonRechercherLivreAjoutLivre);
        rechercher.setVisibility(View.INVISIBLE);
        final TextView titreSelectionLivre = (TextView) findViewById(R.id.textViewSelectionLivreAjoutLivre);
        titreSelectionLivre.setVisibility(View.INVISIBLE);
        final Traitement trait = new Traitement();



        Button isbn = (Button) findViewById(R.id.buttonChoixIsbnAjoutLivre);
        isbn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                titreChoixIsbn.setVisibility(View.VISIBLE);
                inputIsbn.setVisibility(View.VISIBLE);
                titreChoixTitre.setVisibility(View.INVISIBLE);
                inputTitre.setVisibility(View.INVISIBLE);
                rechercher.setVisibility(View.VISIBLE);
            }
        });

        Button titre = (Button) findViewById(R.id.buttonChoixTitreAjoutLivre);
        titre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                titreChoixIsbn.setVisibility(View.INVISIBLE);
                inputIsbn.setVisibility(View.INVISIBLE);
                titreChoixTitre.setVisibility(View.VISIBLE);
                inputTitre.setVisibility(View.VISIBLE);
                rechercher.setVisibility(View.VISIBLE);
            }
        });

        rechercher.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean ok = false;
                String url = "https://www.googleapis.com/books/v1/volumes?q=";
                if(titreChoixIsbn.getVisibility() == View.VISIBLE){
                    if(isNotEmpty(inputIsbn.getText().toString())){
                        url = url+"isbn:"+ inputIsbn.getText().toString().replaceAll(" ", "") + "&maxResults=10";
                        ok = true;
                    }else{
                        popup("ISBN absent", "Vous n\'avez pas indiqué l\'ISBN du livre.");
                    }
                }
                else if(titreChoixTitre.getVisibility() == View.VISIBLE){
                    if(isNotEmpty(inputTitre.getText().toString())){
                        url = url+ inputTitre.getText().toString().replaceAll(" ", "") + "&maxResults=10";
                        ok=true;
                    }else{
                        popup("Titre du livre absent", "Vous n\'avez pas indiqué le titre du livre.");
                    }
                }

                if(ok){
                    final List<Livre> livres = trait.livreList(url);
                    if(livres.size() != 0 ){
                        titreSelectionLivre.setVisibility(View.VISIBLE);

                        LivreAdapter adapter = new LivreAdapter(AjoutLivreActivity.this, livres);
                        mListView = (ListView) findViewById(R.id.listViewListLivreRechercherAjoutLivre);
                        mListView.setAdapter(adapter);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent mIntent = new Intent(AjoutLivreActivity.this, AjoutLivreFinalActivity.class);
                                Bundle mBundle = new Bundle();
                                livres.get(position).setCouverture(null);
                                mBundle.putSerializable("vueLivre", livres.get(position));
                                mIntent.putExtras(mBundle);
                                startActivity(mIntent);
                            }
                        });
                    }else{
                        popup("ISBN ou titre inconnue","L\'ISBN ou le titre que vous n\'avez indiquez ne nous permet de trouver aucun livre.");
                    }
                }
            }
        });
    }

    private void popup(String titre, String txt){
        AlertDialog alertDialog = new AlertDialog.Builder(AjoutLivreActivity.this).create();
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
