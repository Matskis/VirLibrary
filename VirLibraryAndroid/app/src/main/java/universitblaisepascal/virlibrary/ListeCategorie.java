package universitblaisepascal.virlibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cyril on 02/03/2016.
 */
public class ListeCategorie {

    private List<Categorie> listCat= new ArrayList<Categorie>();

    public List<Categorie> getListCat() {
        return listCat;
    }

    public void addListCategorie(Categorie categorie){
        listCat.add(categorie);
    }

    public Categorie searchCategorie(int id){
        Categorie cat = null;
        for (int i = 0; i < listCat.size(); i++){
            if(Integer.toString(id) == listCat.get(i).getIdCat()){
                cat = listCat.get(i);
            }
        }
        return cat;
    }

    public Categorie searchCategorie(String categorie){
        Categorie cat = null;
        for (int i = 0; i < listCat.size(); i++){
            if(categorie == listCat.get(i).getCategorie()){
                cat = listCat.get(i);
            }
        }
        return cat;
    }

    public List<Categorie> searchCategorieFils(String categorieMere){
        List<Categorie> cat = new ArrayList<Categorie>();
        for (int i = 0; i < listCat.size(); i++){
            if(categorieMere == listCat.get(i).getCategorieMere()){
                cat.add(listCat.get(i));
            }
        }
        return cat;
    }
}
