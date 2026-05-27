package model;

import java.math.BigDecimal;

/**
 * Classe furgone, classe figlia di veicolo, ne eredita i campi e metodi e aggiunge la capacità di carico.
 */
public class Furgone extends Veicolo {

    private  float capacitaCarico;

    /**
     * Istanzia un oggetto furgone.
     *
     * @param targa           targa
     * @param modello         modello
     * @param marca           marca
     * @param tariffeDie      tariffe die
     * @param statoVeicolo    stato veicolo
     * @param capacitaCarico  capacita carico
     */
    public Furgone(String targa, String modello, String marca, BigDecimal tariffeDie,
     StatoVeicolo statoVeicolo, float capacitaCarico) {
        super(targa, modello, marca, tariffeDie, statoVeicolo);
        this.capacitaCarico = capacitaCarico;
    }

    /**
     * Ritorna la capacità di carico.
     *
     *
     */
//Metodi Getter
    public float getCapacitaCarico(){return capacitaCarico;}

    /**
     * Imposta la capacita carico.
     *
     *
     */
//Metodi Setter
    public void setCapacitaCarico(float capacitaCarico){
        this.capacitaCarico = capacitaCarico;
    }

    /**
     * Verifica che la capacita di carico sia un intero positivo non nullo,
     *
     *
     */
    public boolean verificaCapacitaCarico(){
        return  this.capacitaCarico > 0;
    }


    @Override
    public  String toString(){
        return "Furgone [Targa=" + getTarga()
        +", Modello=" + getModello()
        +", Marca=" + getMarca()
        +", tariffaDie=" + getTariffaDie()
        +", StatoVeicolo=" + getStatoVeicolo()
        +", capacitaCarico=" + capacitaCarico + "]" ;
    }
}
