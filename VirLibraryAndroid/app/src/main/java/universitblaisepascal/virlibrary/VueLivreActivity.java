package universitblaisepascal.virlibrary;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VueLivreActivity extends AppCompatActivity {
    ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vue_livre);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Profil profil = (Profil) getApplicationContext();
        final Livre livre;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        livre = (Livre) intent.getSerializableExtra("vueLivre");

        TextView titre = (TextView)findViewById(R.id.titre_commentaire_vue_livre_fragment);
        titre.setText(livre.getTitre() + " " + livre.getAuteur());
        TextView isbn = (TextView)findViewById(R.id.isbn_livre_fragment);
        isbn.setText("ISBN : " + livre.getISBN());
        TextView prix = (TextView)findViewById(R.id.txtPrixAjoutLivreFinal);
        String  prixS= "";
        if(livre.getPrix() != null){prixS = livre.getPrix() + " "+ livre.getDevise();}
        prix.setText(prixS);
        TextView edition = (TextView)findViewById(R.id.edition_livre_fragment);
        edition.setText(livre.getEdition());
        TextView dateEdition = (TextView)findViewById(R.id.date_edition_livre_fragment);
        dateEdition.setText(livre.getDateEdition());
        TextView resume = (TextView)findViewById(R.id.resume_livre_fragment);
        resume.setText(livre.getResume());
        TextView langue = (TextView)findViewById(R.id.langue_livre_fragment);
        langue.setText(livre.getLangue());
        Switch empruntable = (Switch) findViewById(R.id.switchEmpruntVueLivre);
        empruntable.setChecked(livre.pretable);
        empruntable.setClickable(false);

        final EditText dateDebutEmprunt = (EditText) findViewById(R.id.dateDebutEmpuntVueLivre);
        final EditText dateFinEmprunt = (EditText) findViewById(R.id.dateFinEmpuntVueLivre);

        if(!livre.pretable){
            dateDebutEmprunt.setVisibility(View.INVISIBLE);
            dateFinEmprunt.setVisibility(View.INVISIBLE);
        }

        mListView = (ListView) findViewById(R.id.listViewCommentaireVueLivre);
        final List<Commentaire> commentaires = new ArrayList<Commentaire>();
        commentaires.add(new Commentaire("c\'est un livre qui vos le détours, je recommande.","Sympa", "22/01/2016", "Pluc"));
        commentaires.add(new Commentaire("C'est un livre avec une histoire très profonde qui fais plaisir à lire à notre époque.", "très bon livre","10/12/2015","Matskis"));

        CommentaireVueLivreAdapter adapter = new CommentaireVueLivreAdapter(VueLivreActivity.this, commentaires);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        Button emprunter = (Button)findViewById(R.id.buttonEmpruntVueLivre);
        emprunter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String dateDebut = dateDebutEmprunt.getText().toString();
                String fin = dateFinEmprunt.getText().toString();


                if (isNotEmpty(dateDebut) && isNotEmpty(fin)) {
                    //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy hh:mi:ss");
                    //Date date = sdf.parse(fin);
                    //Date dateFin = sdf.parse(fin);
                    /*if (date.compareTo(dateFin) != -1) {
                        popup("Les dates d\'emprunt sont incorrect.", "La date de fin d\'emprunt que vous avez indiqué est inférieur à la date de début.\n Veuillez recommencez.");
                    } else {*/
                        if (profil.getDATE_CREATION() != null) {
                            List<Emprunt> emprunts = profil.getEmprunts();
                            emprunts.add(new Emprunt(dateDebut, fin, livre, true));
                            profil.setEmprunts(emprunts);
                            Intent intent = new Intent(VueLivreActivity.this, EmpruntActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(VueLivreActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    //}
                }
            }
        });

        //ajout un commentaire sur un exemplaire
        final Button nouveauCommentaire = (Button)findViewById(R.id.buttonNouveauCommentaireVueLivre);
        nouveauCommentaire.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(profil.getDATE_CREATION() == null){
                    Intent intent = new Intent(VueLivreActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                EditText commentaire = (EditText) findViewById(R.id.inputCommentaireVueLivre);
                EditText titre = (EditText) findViewById(R.id.inputTitreCommentaireVueLivre);
                String commentaireTitre = titre.getText().toString();
                String format = "dd/MM/yy H:mm:ss";

                java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
                java.util.Date date = new java.util.Date();

                String commentaireTxt = commentaire.getText().toString();
                if(!isNotEmpty(commentaireTxt)){
                    popup("Le commentaire n\'est pas remplie.", "Veuillez écrire votre commentaire avant de le poster.");
                }
                if(!isNotEmpty(commentaireTitre)){
                    popup("Le titre du commentaire n\'est pas remplie.", "Veuillez écrire votre titre de commentaire avant de le poster.");
                }
                if(isNotEmpty(commentaireTxt)&& isNotEmpty(commentaireTitre)){
                    commentaires.add(new Commentaire(commentaireTxt, commentaireTitre, date.toString(), profil.getUSERNAME()));
                    commentaire.setVisibility(View.INVISIBLE);
                    titre.setVisibility(View.INVISIBLE);
                    nouveauCommentaire.setVisibility(View.INVISIBLE);
                    Commentaire commen = new Commentaire(commentaireTxt, commentaireTitre, date.toString(), profil.getUSERNAME());
                    popup("Commentaire", commen.toString());
                    popup("Commentaire correctement ajouté", "Votre commentaire a été correctement ajouté. Merci de votre contribution.");
                }
            }
        });
    }

    public void onStart(){
        super.onStart();
        EditText txtDate= (EditText) findViewById(R.id.dateDebutEmpuntVueLivre);
        txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DateDialog dialog = new DateDialog(v);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "Date de début d\'emprunt");
                }
            }
        });

        EditText txtDateRetour= (EditText) findViewById(R.id.dateFinEmpuntVueLivre);
        txtDateRetour.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DateDialog dialog = new DateDialog(v);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "Date de fin d\'emprunt");
                }
            }
        });
    }

    private void popup(String titre, String txt){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
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
