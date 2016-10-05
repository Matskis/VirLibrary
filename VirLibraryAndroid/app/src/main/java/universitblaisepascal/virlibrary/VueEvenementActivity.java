package universitblaisepascal.virlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

public class VueEvenementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vue_evenement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Evenement evenement;
        Intent intent = getIntent();
        evenement = (Evenement) intent.getSerializableExtra("vueEvenement");

        TextView titre = (TextView)findViewById(R.id.titre_commentaire_vue_livre_fragment);
        titre.setText(evenement.getTitre());
        TextView isbn = (TextView)findViewById(R.id.txtPrixAjoutLivreFinal);
        isbn.setText(Html.fromHtml(evenement.getDescription()));
    }

}
