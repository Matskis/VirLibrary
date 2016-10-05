package universitblaisepascal.virlibrary;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final Profil profil = (Profil) getApplicationContext();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AjoutLivreActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Menu menu = navigationView.getMenu();
        MenuItem connexion = menu.findItem(R.id.nav_connexion);
        MenuItem inscrition = menu.findItem(R.id.nav_inscription);
        MenuItem deconnexion = menu.findItem(R.id.nav_deconnexion);
        MenuItem compte = menu.findItem(R.id.nav_compte);
        MenuItem preference = menu.findItem(R.id.nav_preference);
        MenuItem emprunt = menu.findItem(R.id.nav_emprunt);
        MenuItem pret = menu.findItem(R.id.nav_pret);
        MenuItem badge = menu.findItem(R.id.nav_badge);
        MenuItem biblio = menu.findItem(R.id.nav_biblithoque);
        if(profil.getDATE_CREATION() != null){
            inscrition.setVisible(false);
            connexion.setVisible(false);
            compte.setVisible(true);
            preference.setVisible(true);
            emprunt.setVisible(true);
            pret.setVisible(true);
            badge.setVisible(true);
            biblio.setVisible(true);
        }
        else{
            deconnexion.setVisible(false);
            compte.setVisible(false);
            preference.setVisible(false);
            emprunt.setVisible(false);
            pret.setVisible(false);
            badge.setVisible(false);
            biblio.setVisible(false);
        }

        mListView = (ListView) findViewById(R.id.myListView);
        String url ="";
        Traitement trait = new Traitement();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(getIntent() != null && getIntent().getExtras() != null){
            url = getIntent().getExtras().getString("recherche");

            // TODO: Do something with the value of isNew.
        }else{
            url = "https://www.googleapis.com/books/v1/volumes?q=a&maxResults=10";
        }

        final List<Livre> livres = trait.livreList(url);
        LivreAdapter adapter = new LivreAdapter(MainActivity.this, livres);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id ){
                Intent mIntent = new Intent(MainActivity.this ,VueLivreActivity.class);
                Bundle mBundle = new Bundle();
                livres.get(position).setCouverture(null);
                mBundle.putSerializable("vueLivre", livres.get(position));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //reglageMenu(profil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        } else if(id == R.id.action_search){
            startActivity(new Intent(MainActivity.this, SearchActivity.class));
        }
        else if(id == R.id.action_refresh){
            startActivity(new Intent(MainActivity.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_connexion) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        } else if (id == R.id.nav_preference) {
            startActivity(new Intent(MainActivity.this, ItemListActivity.class));
        } else if (id == R.id.nav_emprunt) {
            startActivity(new Intent(MainActivity.this, EmpruntActivity.class));
        } else if (id == R.id.nav_pret) {

        } else if(id == R.id.nav_info){
            startActivity(new Intent(MainActivity.this, InformationActivity.class));
        }
        else if(id == R.id.nav_compte){
            Intent mIntent = new Intent(MainActivity.this, CompteActivity.class);
            startActivity(mIntent);
        }
        else if(id == R.id.nav_evenement){
            startActivity(new Intent(MainActivity.this, EvenementActivity.class));
        }
        else if(id == R.id.nav_accueil){
            startActivity(new Intent(MainActivity.this, MainActivity.class));
        }
        else if(id == R.id.nav_inscription){
            startActivity(new Intent(MainActivity.this, InscriptionActivity.class));
        }
        else if(id == R.id.nav_deconnexion){
            final Profil profil = (Profil) getApplicationContext();
            reglageMenu(profil);
        }
        else if(id == R.id.nav_badge){
            startActivity(new Intent(MainActivity.this, BadgeActivity.class));
        }
        else if(id == R.id.nav_biblithoque){
            startActivity(new Intent(MainActivity.this, BibliothequeActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }

    public void reglageMenu(Profil profil){

        profil.setAdressePrincipal(null);
        profil.setDATE_CREATION(null);
        profil.setUSER_DATE_NAISSANCE(null);
        profil.setUSER_EMAIL(null);
        profil.setUSER_DATE_NAISSANCE(null);
        profil.setUSER_STATUT(null);
        profil.setUSER_MDP(null);
        profil.setUSER_TELEPHONE(null);
        profil.setUSER_NOM(null);
        profil.setUSER_PRENOM(null);
        profil.setUSERNAME(null);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        MenuItem connexion = menu.findItem(R.id.nav_connexion);
        MenuItem inscrition = menu.findItem(R.id.nav_inscription);
        MenuItem deconnexion = menu.findItem(R.id.nav_deconnexion);
        MenuItem compte = menu.findItem(R.id.nav_compte);
        MenuItem preference = menu.findItem(R.id.nav_preference);
        MenuItem emprunt = menu.findItem(R.id.nav_emprunt);
        MenuItem pret = menu.findItem(R.id.nav_pret);
        MenuItem biblio = menu.findItem(R.id.nav_biblithoque);
        inscrition.setVisible(true);
        connexion.setVisible(true);
        deconnexion.setVisible(false);
        compte.setVisible(false);
        preference.setVisible(false);
        emprunt.setVisible(false);
        pret.setVisible(false);
        biblio.setVisible(false);
        this.invalidateOptionsMenu();
    }

    private void popup(String titre, String txt){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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
}
