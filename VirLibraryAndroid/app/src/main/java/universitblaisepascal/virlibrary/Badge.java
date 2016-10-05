package universitblaisepascal.virlibrary;

/**
 * Created by Cyril on 16/03/2016.
 */
public class Badge {

    private String titre;
    private int idBadge;
    private String description;
    private char type;
    private String sousCat;

    public Badge(String titre, String description, char type, String sousCat, int idBadge) {
        this.titre = titre;
        this.description = description;
        this.type = type;
        this.sousCat = sousCat;
        this.idBadge = idBadge;
    }

    public Badge(String titre, String description, char type) {
        this.titre = titre;
        this.description = description;
        this.type = type;
    }

    public Badge(int idBadge, String titre) {
        this.idBadge = idBadge;
        this.titre = titre;
    }

    public String getSousCat() {
        return sousCat;
    }

    public void setSousCat(String sousCat) {
        this.sousCat = sousCat;
    }

    public int getIdBadge() {
        return idBadge;
    }

    public void setIdBadge(int idBadge) {
        this.idBadge = idBadge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
