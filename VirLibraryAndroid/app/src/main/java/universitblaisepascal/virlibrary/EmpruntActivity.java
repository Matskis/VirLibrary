package universitblaisepascal.virlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class EmpruntActivity extends AppCompatActivity {

    private WebService web = new WebService();
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprunt);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final Profil profil = (Profil) getApplicationContext();
        mListView = (ListView) findViewById(R.id.myListViewEmprunt);
        final List<Emprunt> livres = profil.getEmprunts();

        EmpruntAdapter adapter = new EmpruntAdapter(this, livres);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private List<Pret> genererLivre() {
        List<Pret> livres = new ArrayList<Pret>();

        livres.add(new Pret("Pannier", new Livre("12", "Les fleurs du mal", "Français", "Soleil", "Les Fleurs du mal est le titre d'un recueil de poèmes en vers de Charles Baudelaire, englobant la quasi-totalité de sa production poétique, de 1840 jusqu'à sa mort survenue fin août 1867.", "Charles Baudelaire"), true, "22/02/16", "27/02/16"));
        livres.add(new Pret("Jijane", new Livre("8,25", "Alcools", "Français", "French Edition", "Alcools est un recueil de poèmes de Guillaume Apollinaire, paru en 1913.", "Guillaume Apollinaire"), false, "18/03/16", "22/03/16"));
        livres.add(new Pret("Colas",new Livre("15,08", "Paroles", "Français", "Folio", "Paroles est un recueil de poèmes de Jacques Prévert publié pour la première fois en 1946.","Jacques Prévert"), true, "02/04/16", "05/04/16"));
        return livres;
    }
}
