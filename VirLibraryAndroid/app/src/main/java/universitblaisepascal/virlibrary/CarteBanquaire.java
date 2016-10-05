package universitblaisepascal.virlibrary;

import java.io.Serializable;

/**
 * Created by Cyril on 14/03/2016.
 */
public class CarteBanquaire implements Serializable{
    private int id;
    private String numeroCarte;
    private String dateValidite;
    private String proprietaire;
    private int codeSecu;
    private String typeCarte;

    public CarteBanquaire(String typeCarte, String proprietaire, int id, String numeroCarte, String dateValidite, int codeSecu) {
        this.typeCarte = typeCarte;
        this.proprietaire = proprietaire;
        this.id = id;
        this.numeroCarte = numeroCarte;
        this.dateValidite = dateValidite;
        this.codeSecu = codeSecu;
    }

    public int getCodeSecu() {
        return codeSecu;
    }

    public void setCodeSecu(int codeSecu) {
        this.codeSecu = codeSecu;
    }

    public CarteBanquaire(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public String getDateValidite() {
        return dateValidite;
    }

    public void setDateValidite(String dateValidite) {
        this.dateValidite = dateValidite;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getTypeCarte() {
        return typeCarte;
    }

    public void setTypeCarte(String typeCarte) {
        this.typeCarte = typeCarte;
    }
}
