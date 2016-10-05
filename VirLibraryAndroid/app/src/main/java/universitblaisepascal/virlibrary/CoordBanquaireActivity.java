package universitblaisepascal.virlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class CoordBanquaireActivity extends AppCompatActivity {

    ListView mListView;
    ListView mListViewComteBanquaire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coord_banquaire);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(CoordBanquaireActivity.this, AjouteCarteBanquaireActivity.class);
                startActivity(mIntent);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Profil profil = (Profil) getApplicationContext();
        final List<CarteBanquaire> listCarte = profil.getCoordBanquaire().getCarteBanquaire();
        if(listCarte.size() == 0){
            listCarte.add(new CarteBanquaire("Master Card", "Pannier Cyril", 1, "8231721982614592", "12/18", 125));
            listCarte.add(new CarteBanquaire("Master Card", "Pannier Cyril", 2, "1376298318892648", "03/19", 726));
        }

        TextView carteBanquaireVide = (TextView) findViewById(R.id.txtviewListCarteBanquaireVide);
        if(listCarte.size() != 0){
            carteBanquaireVide.setVisibility(View.INVISIBLE);
        }

        CarteCreditAdapter adapter = new CarteCreditAdapter(CoordBanquaireActivity.this, listCarte);
        mListView = (ListView) findViewById(R.id.listViewCarteBanquaire);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(CoordBanquaireActivity.this, MainActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("vueCarte", listCarte.get(position));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        final List<CompteBanquaire> listCompte = profil.getCoordBanquaire().getCompteBanquaire();
        if(listCompte.size() == 0){
            listCompte.add(new CompteBanquaire("Rjijane", 12, 512, 285148, 2817, "FR159F8249", "18383"));
        }
        TextView compteBanquaireVide = (TextView) findViewById(R.id.txtViewAucunCompteAjouteCoordBanquaire);
        if(listCompte.size() != 0){
            compteBanquaireVide.setVisibility(View.INVISIBLE);
        }

        CompteBanquaireAdapter adapterCompte = new CompteBanquaireAdapter(CoordBanquaireActivity.this, listCompte);
        mListViewComteBanquaire = (ListView) findViewById(R.id.listViewCompteBanquaire);
        mListViewComteBanquaire.setAdapter(adapterCompte);
        mListViewComteBanquaire.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Intent mIntent = new Intent(CoordBanquaireActivity.this, MainActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("vueCarte", listCarte.get(position));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);*/

            }
        });

    }
}
