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
import android.widget.TextView;

public class BibliothequeActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibliotheque);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Profil profil = (Profil) getApplicationContext();
        if(profil.getLivres().size() != 0) {
            TextView txtAucunLivre = (TextView) findViewById(R.id.txtviewAucunLivreBibliotheque);
            txtAucunLivre.setVisibility(View.INVISIBLE);
            LivreAdapter adapter = new LivreAdapter(BibliothequeActivity.this, profil.getLivres());
            mListView = (ListView) findViewById(R.id.listViewLivresBibliotheque);
            mListView.setAdapter(adapter);
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent mIntent = new Intent(BibliothequeActivity.this, VueLivreActivity.class);
                    Bundle mBundle = new Bundle();
                    profil.getLivres().get(position).setCouverture(null);
                    mBundle.putSerializable("vueLivre", profil.getLivres().get(position));
                    mIntent.putExtras(mBundle);
                    startActivity(mIntent);
                }
            });
        }
    }

}
