package universitblaisepascal.virlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;

public class CompteActivity extends AppCompatActivity {

    Profil profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Profil profil = (Profil) getApplicationContext();

        TextView pseudo = (TextView) findViewById(R.id.textViewPseudoCompte);
        TextView nom = (TextView) findViewById(R.id.textViewNomCompte);
        TextView prenom = (TextView) findViewById(R.id.textViewPrenomCompte);
        TextView email = (TextView) findViewById(R.id.textViewEmailCompte);
        TextView sexe = (TextView) findViewById(R.id.textViewSexeCompte);
        TextView dateCreation = (TextView) findViewById(R.id.textViewDateCreationCompte);
        TextView statut = (TextView) findViewById(R.id.textViewStatutCompte);
        TextView dateNaissance = (TextView) findViewById(R.id.textViewDateNaiss);
        TextView telephone = (TextView) findViewById(R.id.textViewTelephoneCompte);
        TextView reputation = (TextView) findViewById(R.id.textViewReputationCompte);
        TextView adresse = (TextView) findViewById(R.id.textViewAdresseLigneCompte);
        TextView cp = (TextView) findViewById(R.id.textViewCpCompte);
        TextView ville = (TextView) findViewById(R.id.textViewVilleCompte);
        TextView pays = (TextView) findViewById(R.id.textViewPaysCompte);

        DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

        pseudo.setText(profil.getUSERNAME());
        nom.setText(profil.getUSER_NOM());
        prenom.setText(profil.getUSER_PRENOM());
        sexe.setText(Character.toString(profil.getUSER_SEXE()));
        email.setText(profil.getUSER_EMAIL());
        dateCreation.setText(mediumDateFormat.format(profil.getDATE_CREATION()));
        statut.setText(profil.getUSER_STATUT());
        dateNaissance.setText(profil.getUSER_DATE_NAISSANCE());
        telephone.setText(profil.getUSER_TELEPHONE());
        reputation.setText(Integer.toString(profil.getUSER_REPUTATION()));
        adresse.setText(profil.getAdresse().getADRESSE_LIGNE1());
        cp.setText(profil.getAdresse().getCODE_POSTAL());
        ville.setText(profil.getAdresse().getVILLE());
        pays.setText(profil.getAdresse().getPAYS());

        Button coordBanquaire = (Button) findViewById(R.id.buttonCoordBanquaireCompte);
        coordBanquaire.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(CompteActivity.this, CoordBanquaireActivity.class));
            }
        });
    }
}
