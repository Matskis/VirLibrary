package universitblaisepascal.virlibrary;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Created by Rachid on 07/03/2016.
 */
public class Traitement {

    Random rand;

    public List<Livre> listOuvrage (){

        String jason = recupDonnee("http://192.168.43.206:80/biblio/ouvrage/all");
        List<Livre> listLivre = new ArrayList<Livre>();
        JSONArray listOuv;
        int id_entity;

        List<Exemplaire> listExemp = listExemplaire();

        try {
            JSONObject unelement;
            Livre livre = new Livre();
            listOuv = new JSONArray(jason);
            int pos;

            for (int i = 0; i< listOuv.length() ;i++){
                unelement=listOuv.getJSONObject(i);
                if(!unelement.isNull("titre"))
                    livre.setTitre(unelement.getString("titre"));
                if(!unelement.isNull("dateParution"))
                    livre.setDateParution(unelement.getJSONObject("dateParution").getString("date"));
                if(!unelement.isNull("langue"))
                    livre.setLangue(unelement.getString("langue"));
                if(!unelement.isNull("ID_ENTITY")) {
                    id_entity = unelement.getInt("ID_ENTITY");
                    pos = positionID_entity(listExemp, id_entity);

                    if ( pos!=-1){
                        Exemplaire ex = listExemp.get(pos);
                        livre.setPrix(String.valueOf(ex.getPrix_actuel()));
                        if (ex.getPretable()!= 0)
                            livre.setPretable(true);
                        else
                            livre.setPretable(false);
                    }

                }
                listLivre.add(livre);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



        return listLivre;
    }

    public List<Exemplaire> listExemplaire (){

        String jason = recupDonnee("http://192.168.43.206/biblio/exemplaire/all");

        JSONArray listEdit = null;
        List<Exemplaire> exemp = new ArrayList<Exemplaire>();
        try {
            JSONObject unelement;
            Exemplaire explaire = new Exemplaire();
            listEdit = new JSONArray(jason);

            for (int i = 0; i< listEdit.length() ;i++){
                unelement=listEdit.getJSONObject(i);
                if(!unelement.isNull("etat"))
                    explaire.setEtat(unelement.get("etat").toString());
                if(!unelement.isNull("dateAchat"))
                    explaire.setDate_achat(unelement.getString("dateAchat"));
                if(!unelement.isNull("pretable"))
                    explaire.setPretable(unelement.getInt("pretable"));
                if(!unelement.isNull("prixActuel"))
                    explaire.setPrix_actuel(Float.valueOf(unelement.getString("prixActuel")));
                if(!unelement.isNull("ID_ENTITY"))
                    explaire.setId_entity(unelement.getInt("ID_ENTITY"));
                if(!unelement.isNull("dateCreation")) {
                    explaire.setDate_creation(unelement.getJSONObject("dateCreation").getString("date"));
                }
                exemp.add(explaire);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return exemp;
    }

    private String recupDonnee (String lien ){
        WebService web = new WebService();

        web.setLien(lien);
        String s = "";
        try {
            s = web.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return s;
    }

    private int positionID_entity (List<Exemplaire> exemplaires, int id_entity){

        int i = 0;
        for (Exemplaire ex : exemplaires){
            if (ex.getId_entity() == id_entity)
                return i;
            i+=1;
        }

        return -1;
    }


    public List<Evenement> evenementList(){
        List<Evenement> list = new ArrayList<Evenement>();
        String jason = recupDonnee("http://virlibrary.pe.hu/biblio/evenement/allEvent");

        JSONArray listEdit = null;
        try {
            JSONObject unelement;
            Evenement evenement;
            listEdit = new JSONArray(jason);

            for (int i = 0; i< listEdit.length() ;i++){
                evenement = new Evenement();
                unelement=listEdit.getJSONObject(i);
                if(!unelement.isNull("eventTitre"))
                    evenement.setTitre(unelement.get("eventTitre").toString());
                if(!unelement.isNull("eventDescription"))
                    evenement.setDescription(unelement.getString("eventDescription"));
                if(!unelement.isNull("eventId"))
                    evenement.setId(unelement.getInt("eventId"));
                list.add(evenement);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }





    public List<Livre> livreList(String url) {
        String jason = recupDonnee(url);
        rand = new Random();

        ArrayList<Livre> books = new ArrayList<Livre>();

        Image im = null;

        JSONArray listEdit = null;
        try {
            JSONObject unelement;
            Livre unLivre;
            JSONObject lejason = new JSONObject(jason);
            listEdit = lejason.getJSONArray("items");

            int tailleListe = listEdit.length();

            for (int i = 0 ; i < tailleListe; i++){
                unLivre = new Livre();
                unelement = listEdit.getJSONObject(i);
                unLivre.setTitre(unelement.getJSONObject("volumeInfo").getString("title"));
                if (!unelement.getJSONObject("volumeInfo").isNull("publishedDate")){
                    unLivre.setDateParution(unelement.getJSONObject("volumeInfo").getString("publishedDate"));
                    unLivre.setDateEdition(unelement.getJSONObject("volumeInfo").getString("publishedDate"));
                }
                if (!unelement.getJSONObject("volumeInfo").isNull("language"))
                    unLivre.setLangue(unelement.getJSONObject("volumeInfo").getString("language"));
                if (!unelement.getJSONObject("volumeInfo").isNull("publisher"))
                    unLivre.setEdition(unelement.getJSONObject("volumeInfo").getString("publisher"));
                if (!unelement.getJSONObject("volumeInfo").isNull("description"))
                    unLivre.setResume(unelement.getJSONObject("volumeInfo").getString("description"));
                if (!unelement.getJSONObject("saleInfo").isNull("listPrice")) {
                    unLivre.setPrix(unelement.getJSONObject("saleInfo").getJSONObject("listPrice").getString("amount"));
                    unLivre.setDevise(unelement.getJSONObject("saleInfo").getJSONObject("listPrice").getString("currencyCode"));
                }
                if (!unelement.getJSONObject("volumeInfo").isNull("industryIdentifiers"))
                    unLivre.setISBN(unelement.getJSONObject("volumeInfo").getJSONArray("industryIdentifiers").getJSONObject(0).getString("identifier"));
                if (!unelement.getJSONObject("volumeInfo").isNull("publisher"))
                    unLivre.setNomEditeur(unelement.getJSONObject("volumeInfo").getString("publisher"));
                if (!unelement.getJSONObject("saleInfo").isNull("country"))
                    unLivre.setPaysEditeur(unelement.getJSONObject("saleInfo").getString("country"));

                String auteur = "" ;
                if (!unelement.getJSONObject("volumeInfo").isNull("authors")){
                    JSONArray listAuteur = unelement.getJSONObject("volumeInfo").getJSONArray("authors");
                    for( int j=0 ; j<listAuteur.length(); j++ ){
                        auteur= auteur + " / " + listAuteur.get(j).toString();
                    }
                }
                else
                    auteur = "Inconnue";

                unLivre.setAuteur(auteur);

                im = new Image();
                im.setLien(unelement.getJSONObject("volumeInfo").getJSONObject("imageLinks").getString("smallThumbnail"));

                if (!unelement.getJSONObject("volumeInfo").isNull("imageLinks"))
                    unLivre.setCouverture(im.execute().get());
                unLivre.setEtat(getRandomEtat());
                unLivre.setPretable(getRandomBoolean());
                books.add(unLivre);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return books;
    }

    private boolean getRandomBoolean(){
        return rand.nextBoolean();
    }

    private String getRandomEtat(){
        int nombre = rand.nextInt(101);
        String[] etat = {"bon", "normal", "mauvais"};
        return etat[nombre%3];
    }

}
