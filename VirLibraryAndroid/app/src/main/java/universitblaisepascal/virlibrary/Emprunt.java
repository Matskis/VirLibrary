package universitblaisepascal.virlibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cyril on 16/03/2016.
 */
public class Emprunt {

    private String dateDebut;
    private String dateFin;
    private Livre livres = new Livre();
    private Boolean empruntAccepte = false;

    public Emprunt(){}

    public Emprunt(String dateDebut, String dateFin, Livre livres, Boolean empruntAccepte) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.livres = livres;
        this.empruntAccepte = empruntAccepte;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public Livre getLivres() {
        return livres;
    }

    public void setLivres(Livre livres) {
        this.livres = livres;
    }

    public Boolean getEmpruntAccepte() {
        return empruntAccepte;
    }

    public void setEmpruntAccepte(Boolean empruntAccepte) {
        this.empruntAccepte = empruntAccepte;
    }
}
