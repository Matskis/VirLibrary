package universitblaisepascal.virlibrary;

/**
 * Created by Cyril on 09/03/2016.
 */
public class Pret {
    private String emprunteur;
    private Livre livre = new Livre();
    private Boolean empruntAccepte;
    private String dateDebut;
    private String dateFin;

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public Pret (){

    }

    public String getEmprunteur() {
        return emprunteur;
    }

    public Livre getLivre() {
        return livre;
    }

    public Boolean getEmpruntAccepte() {
        return empruntAccepte;
    }

    public void setEmprunteur(String emprunteur) {
        this.emprunteur = emprunteur;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public void setEmpruntAccepte(Boolean empruntAccepte) {
        this.empruntAccepte = empruntAccepte;
    }

    public Pret(String emprunteur, Livre livre, Boolean empruntAccepte, String dateDebut, String dateFin) {
        this.emprunteur = emprunteur;
        this.livre = livre;
        this.empruntAccepte = empruntAccepte;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getDateDebut() {
        return dateDebut;
    }
}
