package universitblaisepascal.virlibrary;

import java.io.Serializable;

/**
 * Created by Cyril on 14/03/2016.
 */
public class CompteBanquaire implements Serializable{
    private String proprio;
    private int codeBanque;
    private int codeGuichet;
    private int numeroCompte;
    private int cleRIB;
    private String IBAN;
    private String codeSwift;

    public CompteBanquaire(String proprio, int codeBanque, int codeGuichet, int numeroCompte, int cleRIB, String IBAN, String codeSwift) {
        this.proprio = proprio;
        this.codeBanque = codeBanque;
        this.codeGuichet = codeGuichet;
        this.numeroCompte = numeroCompte;
        this.cleRIB = cleRIB;
        this.IBAN = IBAN;
        this.codeSwift = codeSwift;
    }

    public  CompteBanquaire(){

    }

    public String getProprio() {
        return proprio;
    }

    public void setProprio(String proprio) {
        this.proprio = proprio;
    }

    public int getCodeBanque() {
        return codeBanque;
    }

    public void setCodeBanque(int codeBanque) {
        this.codeBanque = codeBanque;
    }

    public int getCodeGuichet() {
        return codeGuichet;
    }

    public void setCodeGuichet(int codeGuichet) {
        this.codeGuichet = codeGuichet;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public int getCleRIB() {
        return cleRIB;
    }

    public void setCleRIB(int cleRIB) {
        this.cleRIB = cleRIB;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getCodeSwift() {
        return codeSwift;
    }

    public void setCodeSwift(String codeSwift) {
        this.codeSwift = codeSwift;
    }
}
