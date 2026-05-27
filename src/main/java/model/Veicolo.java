package model;
import java.math.BigDecimal;

/**
 * Classe Veicolo, un veicolo viene noleggiato da un cliente.
 */
public abstract class Veicolo {
    private String targa, modello, marca;
    private BigDecimal tariffaDie;
    private StatoVeicolo statoVeicolo;

    /**
     * Istanzia un veicolo
     *
     * @param targa         targa (identificativo)
     * @param modello       modello
     * @param marca         marca
     * @param tariffaDie    tariffa die
     * @param statoVeicolo  stato veicolo
     */
    public Veicolo(String targa, String modello, String marca, BigDecimal tariffaDie, StatoVeicolo statoVeicolo) {
        this.targa = targa;
        this.modello = modello;
        this.marca = marca;
        this.tariffaDie = tariffaDie;
        this.statoVeicolo = statoVeicolo;
    }

    /**
     * Ritorna la targa.
     *
     *
     */
    public String getTarga() {
        return targa;
    }

    /**
     * Imposta la targa.
     *
     *
     */
    public void setTarga(String targa) {
        this.targa = targa;
    }

    /**
     * Ritorna il  modello.
     *
     *
     */
    public String getModello() {
        return modello;
    }

    /**
     * Imposta modello.
     *
     *
     */
    public void setModello(String modello) {
        this.modello = modello;
    }

    /**
     * Ritorna la marca.
     *
     *
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Imposta la marca.
     *
     *
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Ritorna la tariffa die (tariffa giornaliera)
     *
     *
     */
    public BigDecimal getTariffaDie() {
        return tariffaDie;
    }

    /**
     * Imposta tariffa die.
     *
     *
     */
    public void setTariffaDie(BigDecimal tariffaDie) {
        this.tariffaDie = tariffaDie;
    }

    /**
     * Ritorna stato veicolo.
     *
     *
     */
    public StatoVeicolo getStatoVeicolo() {
        return statoVeicolo;
    }

    /**
     * Imposta stato veicolo.
     *
     *
     */
    public void setStatoVeicolo(StatoVeicolo statoVeicolo) {
        this.statoVeicolo = statoVeicolo;
    }

    /**
     * Verifica dati veicolo .
     *
     *
     */
//controllo validità dei dati del veicolo
    public boolean verificaDatiVeicolo(){
        return this.marca != null && this.statoVeicolo != null && this.modello != null && this.targa != null && this.tariffaDie.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * Verifica stato veicolo .
     *
     *
     *
     */
//verifico la disponibilità del veicolo, restituisco true se è disponibile altrimenti false
    public boolean  verificaStatoVeicolo(StatoVeicolo stato){
        return this.statoVeicolo == stato;
    }

    /**
     * Verifica manutenzione .
     *
     *
     */
    public boolean verificaManutenzione(){
        return this.statoVeicolo == StatoVeicolo.Manutenzione;
    }

    /**
     * Verifica disponibilità.
     *
     *
     */
    public boolean verificaDisponibile(){
        return this.statoVeicolo == StatoVeicolo.Disponibile;
    }

}
