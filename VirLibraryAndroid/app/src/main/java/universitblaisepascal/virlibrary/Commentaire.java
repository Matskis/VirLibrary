package universitblaisepascal.virlibrary;

/**
 * Created by Cyril on 11/03/2016.
 */
public class Commentaire {
    private int id;
    private String text;
    private String titre;
    private String date;
    private String pseudo;
    private int idUser;

    public Commentaire(String text) {
        this.text = text;
    }

    public Commentaire(String text, String titre, String date, String pseudo) {
        this.text = text;
        this.titre = titre;
        this.date = date;
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", titre='" + titre + '\'' +
                ", date='" + date + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", idUser=" + idUser +
                '}';
    }
}
