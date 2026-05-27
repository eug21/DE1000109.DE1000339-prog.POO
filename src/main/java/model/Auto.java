package model;

import java.math.BigDecimal;

/**
 * Classe figlia di veicolo, aggiunge il campo numero di porte.
 */
public class Auto extends Veicolo{

    private int numeroPorte;

    /**
     * Instantiates a new Auto.
     *
     * @param targa         targa
     * @param modello       modello
     * @param marca         marca
     * @param tariffaDie    tariffa die (tariffa giornaliera)
     * @param statoVeicolo  stato veicolo (se è disponibile/noleggiato/manutenzione)
     * @param numeroPorte   numero porte
     */
    public Auto(String targa, String modello, String marca, BigDecimal tariffaDie, StatoVeicolo statoVeicolo, int numeroPorte) {
        super(targa, modello, marca, tariffaDie, statoVeicolo);
        this.numeroPorte = numeroPorte;
    }

    /**
     * Ritorna il numero porte.
     *
     *
     */
    public int getNumeroPorte() {
        return numeroPorte;
    }

    /**
     * Imposta il numero porte.
     *
     *
     */
    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    /**
     * Verifica numero porte che sia un intero positivo.
     *
     * @return the boolean
     */
    public boolean verificaNumeroPorte(){
        return this.numeroPorte > 0;
    }

    /**
     * Verifica che i campi dell'auto siano validi.
     *
     * @return the boolean
     */
    public boolean verificaAutoValida(){
        return verificaDatiVeicolo() && verificaNumeroPorte();
    }

    @Override
    public String toString(){
        return "Auto  return \"Auto [targa=\" + getTarga()\n" +
                "            + \", modello=\" + getModello()\n" +
                "            + \", marca=\" + getMarca()\n" +
                "            + \", tariffaDie=\" + getTariffaDie()\n" +
                "            + \", statoVeicolo=\" + getStatoVeicolo()\n" +
                "            + \", numeroPorte=\" + numeroPorte + \"]\"";
    }
}
