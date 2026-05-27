package model;

import java.math.BigDecimal;

/**
 * Classe moto, classe figlia di veicolo, ne eredita metodi e attributi aggiungendo la cilindrata.
 */
public class Moto extends Veicolo {

    private int cilindrata;

    /**
     * Istanzia un oggetto moto
     *
     * @param targa         targa
     * @param modello       modello
     * @param marca         marca
     * @param tarriffaDie   tarriffa die
     * @param statoVeicolo  stato veicolo
     * @param cilindrata    cilindrata
     */
    public Moto(String targa, String modello, String marca, BigDecimal tarriffaDie, StatoVeicolo statoVeicolo,
    int cilindrata){
        super(targa, modello, marca, tarriffaDie, statoVeicolo);
        this.cilindrata = cilindrata;
    }

    /**
     * Ritorna la cilindrata.
     *
     *
     */
//Metodi Getter
    public  int getCilindrata(){
        return cilindrata;
    }

    /**
     * Imposta la cilindrata.
     *
     *
     */
//Metodi setter
    public  void setCilindrata(int cilindrata){this.cilindrata = cilindrata;}

    /**
     * Verifica che la cilindrata sia valida
     *
     * @return the boolean
     */
//Verifica che la cilindrata sia valida
    public boolean verificaCilindrata(){
        if(this.cilindrata>0){
            return true;
        }
        return false;
    }

    @Override
    public  String toString(){
        return "Moto:[targa=" + getTarga()
        + ", Modello=" + getModello()
        + ", Marca=" + getMarca()
        +", TariffaDie=" + getTariffaDie()
        + ", StatoVeicolo=" + getStatoVeicolo()
        + ", Cilindrata="+ cilindrata + "]";

    }
}
