package universitblaisepascal.virlibrary;

import java.io.Serializable;

/**
 * Created by Cyril on 10/03/2016.
 */
public class Evenement implements Serializable{
    private String titre;
    private String description;
    private int id;

    public Evenement(String titre, String description, int id) {
        this.titre = titre;
        this.description = description;
        this.id = id;
    }

    public Evenement(){

    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
