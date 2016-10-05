package universitblaisepascal.virlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class SearchActivity extends AppCompatActivity {

    int array = R.array.sous_cat_bd_jeunesse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBarSearch);
        progressBar.setVisibility(View.GONE);
        final EditText editRecherche = (EditText) findViewById(R.id.inputRechercheSearch);
        final Spinner editAutheur = (Spinner) findViewById(R.id.spinnerSearchAuteur);

        ImageButton closeSearch = (ImageButton)findViewById(R.id.imageButtonCloseSearch);
        closeSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SearchActivity.this, MainActivity.class));
            }
        });

        ImageButton rechercherSearch = (ImageButton)findViewById(R.id.imageButtonRechercherSearch);
        rechercherSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //méthode pour la recherche de livre
                progressBar.setVisibility(View.VISIBLE);
                String recherche = editRecherche.getText().toString();
                String auteur = editAutheur.getSelectedItem().toString();
                int i=0;

                String url = "https://www.googleapis.com/books/v1/volumes?q="+recherche.replaceAll(" ", "")+"&maxResults=10";
                Intent mIntent = new Intent(SearchActivity.this ,MainActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("recherche", url);
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        Spinner spinnerA = (Spinner) findViewById(R.id.spinnerSearchAuteur);
        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.auteur, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerA.setAdapter(adapter);

        final Spinner spinnerC = (Spinner) findViewById(R.id.spinnerSearchCategorie);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterC = ArrayAdapter.createFromResource(this,
                R.array.categorie, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerC.setAdapter(adapterC);

        spinnerC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (spinnerC.getSelectedItem() == "BD-jeunesse") {
                    array = R.array.sous_cat_bd_jeunesse;
                } else if (spinnerC.getSelectedItem() == "Littérature") {
                    array = R.array.sous_cat_savoir;
                } else if (spinnerC.getSelectedItem() == "Fiction") {
                    array = R.array.sous_cat_fiction;
                } else if (spinnerC.getSelectedItem() == "Art culture") {
                    array = R.array.sous_cat_art_culture;
                } else if (spinnerC.getSelectedItem() == "Vie-pratique") {
                    array = R.array.sous_cat_vie_pratique;
                } else if (spinnerC.getSelectedItem() == "Loisir") {
                    array = R.array.sous_cat_loisir;
                } else if (spinnerC.getSelectedItem() == "Scolaire et université") {
                    array = R.array.sous_cat_scolaire_universite;
                } else if (spinnerC.getSelectedItem() == "Savoir") {
                    array = R.array.sous_cat_savoir;
                } else if (spinnerC.getSelectedItem() == "Publication") {
                    array = R.array.sous_cat_publication;
                }

                Log.e("numéro array", Integer.toString(array));
                Spinner spinnerSC = (Spinner) findViewById(R.id.spinnerSearchSousCategorie);
                // Create an ArrayAdapter using the string array and a default spinner layout
                ArrayAdapter<CharSequence> adapterSC = ArrayAdapter.createFromResource(SearchActivity.this,
                        array, android.R.layout.simple_spinner_item);
                // Specify the layout to use when the list of choices appears
                adapterSC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapterSC.notifyDataSetChanged();
                // Apply the adapter to the spinner
                spinnerSC.setAdapter(adapterSC);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }
}
