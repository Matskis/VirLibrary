package universitblaisepascal.virlibrary;

/**
 * Created by Cyril on 02/03/2016.
 */
public class Categorie {
    private String categorieMere;
    private String categorie;
    private String description;
    private String idCat;

    public String getIdCat() {
        return idCat;
    }

    public void setIdCat(String idCat) {
        this.idCat = idCat;
    }

    public String getCategorieMere() {
        return categorieMere;
    }

    public void setCategorieMere(String categorieMere) {
        this.categorieMere = categorieMere;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Categorie(String categorieMere, String categorie, String description, String idCat) {
        this.categorieMere = categorieMere;
        this.categorie = categorie;
        this.description = description;
        this.idCat = idCat;
    }
}
