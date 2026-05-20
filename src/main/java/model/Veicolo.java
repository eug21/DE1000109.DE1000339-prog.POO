package model;
import java.math.BigDecimal;

public abstract class Veicolo {
    private String targa, modello, marca;
    private BigDecimal tariffaDie;
    private StatoVeicolo statoVeicolo;

    public Veicolo(String targa, String modello, String marca, BigDecimal tariffaDie, StatoVeicolo statoVeicolo) {
        this.targa = targa;
        this.modello = modello;
        this.marca = marca;
        this.tariffaDie = tariffaDie;
        this.statoVeicolo = statoVeicolo;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getTariffaDie() {
        return tariffaDie;
    }

    public void setTariffaDie(BigDecimal tariffaDie) {
        this.tariffaDie = tariffaDie;
    }

    public StatoVeicolo getStatoVeicolo() {
        return statoVeicolo;
    }

    public void setStatoVeicolo(StatoVeicolo statoVeicolo) {
        this.statoVeicolo = statoVeicolo;
    }

    //controllo validità dei dati del veicolo
    public boolean verificaDatiVeicolo(){
        return this.marca != null && this.statoVeicolo != null && this.modello != null && this.targa != null && this.tariffaDie.compareTo(BigDecimal.ZERO) > 0;
    }
//verifico la disponibilità del veicolo, restituisco true se è disponibile altrimenti false
    public boolean  verificaStatoVeicolo(StatoVeicolo stato){
        return this.statoVeicolo == stato;
    }

    public boolean verificaManutenzione(){
        return this.statoVeicolo == StatoVeicolo.Manutenzione;
    }

    public boolean verificaDisponibile(){
        return this.statoVeicolo == StatoVeicolo.Dispoonibile;
    }

}
