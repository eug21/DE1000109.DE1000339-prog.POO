package model;
import java.math.BigDecimal;

/**
 * The type Veicolo.
 */
public abstract class Veicolo {
    private String targa, modello, marca;
    private BigDecimal tariffaDie;
    private StatoVeicolo statoVeicolo;

    /**
     * Instantiates a new Veicolo.
     *
     * @param targa        the targa
     * @param modello      the modello
     * @param marca        the marca
     * @param tariffaDie   the tariffa die
     * @param statoVeicolo the stato veicolo
     */
    public Veicolo(String targa, String modello, String marca, BigDecimal tariffaDie, StatoVeicolo statoVeicolo) {
        this.targa = targa;
        this.modello = modello;
        this.marca = marca;
        this.tariffaDie = tariffaDie;
        this.statoVeicolo = statoVeicolo;
    }

    /**
     * Gets targa.
     *
     * @return the targa
     */
    public String getTarga() {
        return targa;
    }

    /**
     * Sets targa.
     *
     * @param targa the targa
     */
    public void setTarga(String targa) {
        this.targa = targa;
    }

    /**
     * Gets modello.
     *
     * @return the modello
     */
    public String getModello() {
        return modello;
    }

    /**
     * Sets modello.
     *
     * @param modello the modello
     */
    public void setModello(String modello) {
        this.modello = modello;
    }

    /**
     * Gets marca.
     *
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Sets marca.
     *
     * @param marca the marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Gets tariffa die.
     *
     * @return the tariffa die
     */
    public BigDecimal getTariffaDie() {
        return tariffaDie;
    }

    /**
     * Sets tariffa die.
     *
     * @param tariffaDie the tariffa die
     */
    public void setTariffaDie(BigDecimal tariffaDie) {
        this.tariffaDie = tariffaDie;
    }

    /**
     * Gets stato veicolo.
     *
     * @return the stato veicolo
     */
    public StatoVeicolo getStatoVeicolo() {
        return statoVeicolo;
    }

    /**
     * Sets stato veicolo.
     *
     * @param statoVeicolo the stato veicolo
     */
    public void setStatoVeicolo(StatoVeicolo statoVeicolo) {
        this.statoVeicolo = statoVeicolo;
    }

    /**
     * Verifica dati veicolo boolean.
     *
     * @return the boolean
     */
//controllo validità dei dati del veicolo
    public boolean verificaDatiVeicolo(){
        return this.marca != null && this.statoVeicolo != null && this.modello != null && this.targa != null && this.tariffaDie.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * Verifica stato veicolo boolean.
     *
     * @param stato the stato
     * @return the boolean
     */
//verifico la disponibilità del veicolo, restituisco true se è disponibile altrimenti false
    public boolean  verificaStatoVeicolo(StatoVeicolo stato){
        return this.statoVeicolo == stato;
    }

    /**
     * Verifica manutenzione boolean.
     *
     * @return the boolean
     */
    public boolean verificaManutenzione(){
        return this.statoVeicolo == StatoVeicolo.Manutenzione;
    }

    /**
     * Verifica disponibile boolean.
     *
     * @return the boolean
     */
    public boolean verificaDisponibile(){
        return this.statoVeicolo == StatoVeicolo.Disponibile;
    }

}
