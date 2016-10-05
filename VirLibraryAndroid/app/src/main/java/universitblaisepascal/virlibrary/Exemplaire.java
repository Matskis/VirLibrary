package universitblaisepascal.virlibrary;

import java.util.Date;
import java.util.List;

/**
 * Created by Rachid on 06/03/2016.
 */
public class Exemplaire {

    private int id_entity;
    private int edition_id;
    private String date_creation;
    private String etat;
    private String date_achat;
    private int pretable;
    private float prix_actuel;

    @Override
    public String toString() {
        return "Exemplaire{" +
                "id_entity=" + id_entity +
                ", edition_id=" + edition_id +
                ", date_creation=" + date_creation +
                ", etat=" + etat +
                ", date_achat=" + date_achat +
                ", pretable=" + pretable +
                ", prix_actuel=" + prix_actuel +
                '}';
    }

    public int getId_entity() {
        return id_entity;
    }

    public void setId_entity(int id_entity) {
        this.id_entity = id_entity;
    }

    public float getPrix_actuel() {
        return prix_actuel;
    }

    public void setPrix_actuel(float prix_actuel) {
        this.prix_actuel = prix_actuel;
    }

    public int getPretable() {
        return pretable;
    }

    public void setPretable(int pretable) {
        this.pretable = pretable;
    }

    public String getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(String date_achat) {
        this.date_achat = date_achat;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public int getEdition_id() {
        return edition_id;
    }

    public void setEdition_id(int edition_id) {
        this.edition_id = edition_id;
    }
}
