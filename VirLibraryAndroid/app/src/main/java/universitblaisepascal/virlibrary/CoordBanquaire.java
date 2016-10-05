package universitblaisepascal.virlibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cyril on 14/03/2016.
 */
public class CoordBanquaire {

    private List<CarteBanquaire> carteBanquaire = new ArrayList<CarteBanquaire>();
    private List<CompteBanquaire> compteBanquaire = new ArrayList<CompteBanquaire>();

    public CoordBanquaire(List<CarteBanquaire> carteBanquaire, List<CompteBanquaire> compteBanquaire) {
        this.carteBanquaire = carteBanquaire;
        this.compteBanquaire = compteBanquaire;
    }

    public CoordBanquaire(){

    }

    public List<CarteBanquaire> getCarteBanquaire() {
        return carteBanquaire;
    }

    public List<CompteBanquaire> getCompteBanquaire() {
        return compteBanquaire;
    }

    public void addCarteBanquaire(String proprio, String numCarte, String dateFin, String typeCarte, int id, int codeSecu){
        carteBanquaire.add(new CarteBanquaire(typeCarte, proprio, id, numCarte, dateFin, codeSecu));
    }

    public void removeCarteBanquaire(int numCarte){
        for(int i = 0; i < carteBanquaire.size(); i++){
            if(carteBanquaire.get(i).getId() == numCarte){
                carteBanquaire.remove(i);
            }
        }
    }

    public void addCompteBanquaire(String proprio, int codeBanque, int codeGuichet, int numeroCompte, int cleRIB, String IBAN, String codeSwift){
        compteBanquaire.add(new CompteBanquaire(proprio, codeBanque, codeGuichet, numeroCompte, cleRIB, IBAN, codeSwift));
    }

    public void removeCompteBanquaire(int numCompte){
        for(int i = 0; i < carteBanquaire.size(); i++){
            if(compteBanquaire.get(i).getNumeroCompte() == numCompte){
                compteBanquaire.remove(i);
            }
        }
    }
}
