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
import android.widget.Button;
import android.widget.EditText;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InscriptionActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Profil profil =(Profil) getApplicationContext();

        retourSauvegarde(profil);

        Button buttonSuivant = (Button) findViewById(R.id.buttonSuivantInscription);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                recuperInput(profil);

                //si l'email ajouté par l'user est incorrect on affiche un message d'erreur
                if(!isEmail(profil.getUSER_EMAIL())){
                    popup("Email non valide", "L\'email que vous avez rentré n\'est pas valide. Il dois comporter example@example.fr.\n" +
                            "L\'email ne peut comporter que des lettres, chiffres, tiret et underscore.");
                }

                //si le mdp ajouté par l'user est incorrect on affiche un message d'erreur
                if(!isMdpValide(profil.getUSER_MDP())){
                    popup("Mot de passe invalide", "Le mot de passe "+ profil.getUSER_MDP() + " que vous avez rentré n\'est pas valide.\n" +
                            "Le mot de passe dois comporter de 6 à 12 caractéres.\n"+
                            "Au moins une majuscule et une minuscule, un chiffre.");
                }

                if(!isNotEmpty(profil.getUSERNAME())){
                    popup("Pseudo non remplie", "Vous n\'avez pas remplie votre pseudo.");
                }

                if(!isNotEmpty(profil.getUSER_NOM())){
                    popup("Nom non remplie", "Vous n\'avez pas remplie votre nom.");
                }

                if(!isNotEmpty(profil.getUSER_PRENOM())){
                    popup("Prénom non remplie", "Vous n\'avez pas remplie votre prénom.");
                }

                //si tout les inputs sont bon on passe au layout suivant
                if(isEmail(profil.getUSER_EMAIL()) && isMdpValide(profil.getUSER_MDP()) && isNotEmpty(profil.getUSERNAME()) && isNotEmpty(profil.getUSER_NOM()) && isNotEmpty(profil.getUSER_PRENOM())){

                    Intent intent = new Intent(InscriptionActivity.this, Inscription2Activity.class);
                    startActivity(intent);
                }
            }
        });

        Button buttonAnnuler = (Button) findViewById(R.id.buttonAnnulerInscription);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(InscriptionActivity.this, MainActivity.class));
            }
        });
    }

    private void recuperInput(Profil session) {

        EditText input;
        input = (EditText) findViewById(R.id.inputPseudoInscription);
        String pseudo = input.getText().toString();
        input = (EditText) findViewById(R.id.inputNomInscription);
        String nom = input.getText().toString();
        input = (EditText) findViewById(R.id.inputPrenomInscription);
        String prenom = input.getText().toString();
        input = (EditText) findViewById(R.id.inputEmailInscription);
        String email = input.getText().toString();
        input = (EditText) findViewById(R.id.inputMdpInscription);
        String mdp = input.getText().toString();

        session.setUSERNAME(pseudo);
        session.setUSER_NOM(nom);
        session.setUSER_PRENOM(prenom);
        session.setUSER_MDP(mdp);
        session.setUSER_EMAIL(email);

    }

    private void retourSauvegarde( Profil profil) {

        EditText output;
        output = (EditText)findViewById(R.id.inputPseudoInscription);
        output.setText(profil.getUSERNAME());
        output = (EditText)findViewById(R.id.inputNomInscription);
        output.setText(profil.getUSER_NOM());
        output = (EditText)findViewById(R.id.inputPrenomInscription);
        output.setText(profil.getUSER_PRENOM());
        output = (EditText)findViewById(R.id.inputEmailInscription);
        output.setText(profil.getUSER_EMAIL());
        output = (EditText)findViewById(R.id.inputMdpInscription);
        output.setText(profil.getUSER_MDP());

    }

    public boolean isEmail(String email)
    {
        boolean matchFound1;
        boolean returnResult=true;
        email=email.trim();
        if(email.equalsIgnoreCase(""))
            returnResult=false;
        else if(!Character.isLetter(email.charAt(0)))
            returnResult=false;
        else
        {
            Pattern p1 = Pattern.compile("^\\.|^\\@ |^_");
            Matcher m1 = p1.matcher(email.toString());
            matchFound1=m1.matches();

            Pattern p = Pattern.compile("^[a-zA-z0-9._-]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z]{2,4}$");
            // Match the given string with the pattern
            Matcher m = p.matcher(email.toString());

            // check whether match is found
            boolean matchFound = m.matches();

            StringTokenizer st = new StringTokenizer(email, ".");
            String lastToken = null;
            while (st.hasMoreTokens())
            {
                lastToken = st.nextToken();
            }
            if (matchFound && lastToken.length() >= 2
                    && email.length() - 1 != lastToken.length() && matchFound1==false)
            {

                returnResult= true;
            }
            else returnResult= false;
        }
        return returnResult;
    }

    private Boolean isMdpValide(String mdp){
        final String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(mdp);
        return matcher.matches();
    }

    private void popup(String titre, String txt){
        AlertDialog alertDialog = new AlertDialog.Builder(InscriptionActivity.this).create();
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

    //regex date
    //(19|20)\d\d([- /.])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])

}
