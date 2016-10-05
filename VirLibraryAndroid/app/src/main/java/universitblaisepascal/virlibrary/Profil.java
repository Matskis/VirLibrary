package universitblaisepascal.virlibrary;

import android.app.Application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rachid on 04/03/2016.
 */
public class Profil extends Application{

    private String USERNAME = "PseudoTest";
    private String USER_PRENOM;
    private String USER_NOM;
    private String USER_EMAIL = "test@test.com";
    private char USER_SEXE;
    private Date DATE_CREATION;
    private String USER_DATE_NAISSANCE;
    private String USER_MDP;
    private char USER_TYPE;
    private String USER_STATUT;
    private String USER_TELEPHONE;
    private int USER_REPUTATION;
    private Adresse adressePrincipal = new Adresse();
    private CoordBanquaire coordBanquaire = new CoordBanquaire();
    private List<Emprunt> emprunts = new ArrayList<Emprunt>();
    private List<Badge> badge = new ArrayList<Badge>();
    private List<Livre> livres = new ArrayList<Livre>();

    @Override
    public String toString() {
        return "Profil{" +
                "USERNAME='" + USERNAME + '\'' +
                ", USER_PRENOM='" + USER_PRENOM + '\'' +
                ", USER_NOM='" + USER_NOM + '\'' +
                ", USER_EMAIL='" + USER_EMAIL + '\'' +
                ", USER_SEXE=" + USER_SEXE +
                ", DATE_CREATION='" + DATE_CREATION + '\'' +
                ", USER_DATE_NAISSANCE='" + USER_DATE_NAISSANCE + '\'' +
                ", USER_MDP='" + USER_MDP + '\'' +
                ", USER_TYPE=" + USER_TYPE +
                ", USER_STATUT='" + USER_STATUT + '\'' +
                ", USER_TELEPHONE='" + USER_TELEPHONE + '\'' +
                ", USER_REPUTATION=" + USER_REPUTATION +
                ", adresse=" + adressePrincipal.toString() +
                '}';
    }

    public CoordBanquaire getCoordBanquaire() {
        return coordBanquaire;
    }

    public String getUSER_MDP() {
        return USER_MDP;
    }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public Adresse getAdresse() {
        return adressePrincipal;
    }

    public String getUSER_PRENOM() {
        return USER_PRENOM;
    }

    public void setUSER_PRENOM(String USER_PRENOM) {
        this.USER_PRENOM = USER_PRENOM;
    }

    public Adresse getAdressePrincipal() {
        return adressePrincipal;
    }

    public void setAdressePrincipal(Adresse adressePrincipal) {
        this.adressePrincipal = adressePrincipal;
    }

    public String getUSER_NOM() {
        return USER_NOM;
    }

    public void setUSER_NOM(String USER_NOM) {
        this.USER_NOM = USER_NOM;
    }

    public char getUSER_SEXE() {
        return USER_SEXE;
    }

    public void setUSER_SEXE(char USER_SEXE) {
        this.USER_SEXE = USER_SEXE;
    }

    public Date getDATE_CREATION() {
        return DATE_CREATION;
    }

    public void setDATE_CREATION(Date DATE_CREATION) {
        this.DATE_CREATION = DATE_CREATION;
    }

    public String getUSER_DATE_NAISSANCE() {
        return USER_DATE_NAISSANCE;
    }

    public void setUSER_DATE_NAISSANCE(String USER_DATE_NAISSANCE) {
        this.USER_DATE_NAISSANCE = USER_DATE_NAISSANCE;
    }

    public char getUSER_TYPE() {
        return USER_TYPE;
    }

    public void setUSER_TYPE(char USER_TYPE) {
        this.USER_TYPE = USER_TYPE;
    }

    public String getUSER_STATUT() {
        return USER_STATUT;
    }

    public void setUSER_STATUT(String USER_STATUT) {
        this.USER_STATUT = USER_STATUT;
    }

    public String getUSER_TELEPHONE() {
        return USER_TELEPHONE;
    }

    public void setUSER_TELEPHONE(String USER_TELEPHONE) {
        this.USER_TELEPHONE = USER_TELEPHONE;
    }

    public int getUSER_REPUTATION() {
        return USER_REPUTATION;
    }

    public void setUSER_REPUTATION(int USER_REPUTATION) {
        this.USER_REPUTATION = USER_REPUTATION;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public void setUSER_EMAIL(String USER_EMAIL) {
        this.USER_EMAIL = USER_EMAIL;
    }

    public void setUSER_MDP(String USER_MDP) {
        this.USER_MDP = USER_MDP;
    }

    public void setCoordBanquaire(CoordBanquaire coordBanquaire) {
        this.coordBanquaire = coordBanquaire;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public List<Badge> getBadge() {
        return badge;
    }

    public void setBadge(List<Badge> badge) {
        this.badge = badge;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    public void ajouteLivre(Livre livre){
        this.livres.add(livre);
    }

    public void removeLivre(Livre livre){
        this.livres.remove(livre);
    }
}
