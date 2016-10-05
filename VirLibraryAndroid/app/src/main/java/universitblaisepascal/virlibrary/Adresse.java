package universitblaisepascal.virlibrary;

import java.io.Serializable;

/**
 * Created by Cyril on 18/02/2016.
 */
public class Adresse implements Serializable {

    private String ADRESSE_LIGNE1;
    private String ADRESSE_LIGNE2;
    private String VILLE;
    private String CODE_POSTAL;
    private String 	PAYS;

    public String getADRESSE_LIGNE2() {
        return ADRESSE_LIGNE2;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "ADRESSE_LIGNE1='" + ADRESSE_LIGNE1 + '\'' +
                ", ADRESSE_LIGNE2='" + ADRESSE_LIGNE2 + '\'' +
                ", VILLE='" + VILLE + '\'' +
                ", CODE_POSTAL='" + CODE_POSTAL + '\'' +
                ", PAYS='" + PAYS + '\'' +
                '}';
    }

    public void setADRESSE_LIGNE2(String ADRESSE_LIGNE2) {
        this.ADRESSE_LIGNE2 = ADRESSE_LIGNE2;
    }

    public String getVILLE() {
        return VILLE;
    }

    public void setVILLE(String VILLE) {
        this.VILLE = VILLE;
    }

    public String getCODE_POSTAL() {
        return CODE_POSTAL;
    }

    public void setCODE_POSTAL(String CODE_POSTAL) {
        this.CODE_POSTAL = CODE_POSTAL;
    }

    public String getPAYS() {
        return PAYS;
    }

    public void setPAYS(String PAYS) {
        this.PAYS = PAYS;
    }

    public String getADRESSE_LIGNE1() {
        return ADRESSE_LIGNE1;
    }

    public void setADRESSE_LIGNE1(String ADRESSE_LIGNE1) {
        this.ADRESSE_LIGNE1 = ADRESSE_LIGNE1;
    }

    public Adresse(){

    }

    public Adresse(String ADRESSE_LIGNE1, String ADRESSE_LIGNE2, String VILLE, String CODE_POSTAL, String PAYS) {
        this.ADRESSE_LIGNE1 = ADRESSE_LIGNE1;
        this.ADRESSE_LIGNE2 = ADRESSE_LIGNE2;
        this.VILLE = VILLE;
        this.CODE_POSTAL = CODE_POSTAL;
        this.PAYS = PAYS;
    }
}