package universitblaisepascal.virlibrary;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Cyril on 22/02/2016.
 */
public class Livre implements Serializable{

    private String titre;
    private String dateParution;
    private String Langue;
    private String edition;
    private String resume;
    private String prix;
    private String ISBN;
    private String dateEdition;
    private String nomEditeur;
    private String paysEditeur;
    private int nbExemplaire;
    private String dateAchatExemplaire;
    public boolean pretable;
    private String auteur;
    private String devise;
	private String etat;
    private Bitmap couverture;
	
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Livre(){    }

    public Livre(String prix, String titre, String langue, String edition, String resume, String auteur) {
        this.prix = prix;
        this.titre = titre;
        Langue = langue;
        this.edition = edition;
        this.resume = resume;
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", dateParution='" + dateParution + '\'' +
                ", Langue='" + Langue + '\'' +
                ", edition='" + edition + '\'' +
                ", resume='" + resume + '\'' +
                ", prix='" + prix + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", dateEdition='" + dateEdition + '\'' +
                ", nomEditeur='" + nomEditeur + '\'' +
                ", paysEditeur='" + paysEditeur + '\'' +
                ", nbExemplaire=" + nbExemplaire +
                ", dateAchatExemplaire='" + dateAchatExemplaire + '\'' +
                ", pretable=" + pretable +
                ", auteur='" + auteur + '\'' +
                ", devise='" + devise + '\'' +
                '}';
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDateParution() {
        return dateParution;
    }

    public void setDateParution(String dateParution) {
        this.dateParution = dateParution;
    }

    public String getLangue() {
        return Langue;
    }

    public void setLangue(String langue) {
        Langue = langue;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(String dateEdition) {
        this.dateEdition = dateEdition;
    }

    public String getNomEditeur() {
        return nomEditeur;
    }

    public void setNomEditeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }

    public String getPaysEditeur() {
        return paysEditeur;
    }

    public void setPaysEditeur(String paysEditeur) {
        this.paysEditeur = paysEditeur;
    }

    public int getNbExemplaire() {
        return nbExemplaire;
    }

    public void setNbExemplaire(int nbExemplaire) {
        this.nbExemplaire = nbExemplaire;
    }

    public String getDateAchatExemplaire() {
        return dateAchatExemplaire;
    }

    public void setDateAchatExemplaire(String dateAchatExemplaire) {
        this.dateAchatExemplaire = dateAchatExemplaire;
    }

    public boolean isPretable() {
        return pretable;
    }

    public void setPretable(boolean pretable) {
        this.pretable = pretable;
    }

    public Bitmap getCouverture() {
        return couverture;
    }

    public void setCouverture(Bitmap couverture) {
        this.couverture = couverture;
    }
}
