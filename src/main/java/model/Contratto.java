package model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.math.BigDecimal;

/**
 * Classe contratto, classe associativa tra cliente e veicolo.
 */
public class Contratto {
    private String idFilialeRitiro;
    private String idFilialeConsegna;

    /**
     * Ritorna la targa del veicolo noleggiato.
     *
     *
     */
    public String getTargaVeicolo() {
        return targaVeicolo;
    }

    /**
     * Imposta la targa del veicolo noleggiato nel  contratto.
     *
     *
     */
    public void setTargaVeicolo(String targaVeicolo) {
        this.targaVeicolo = targaVeicolo;
    }

    /**
     * Istanzia un oggetto contratto
     *
     * @param idFilialeRitiro    id filiale ritiro
     * @param idFilialeConsegna  id filiale consegna
     * @param targaVeicolo      targa veicolo
     * @param dataInizio         data inizio
     * @param dataFine           data fine
     * @param prezzo             prezzo
     */
    public Contratto(String idFilialeRitiro, String idFilialeConsegna, String targaVeicolo, LocalDate dataInizio, LocalDate dataFine, BigDecimal prezzo) {
        this.idFilialeRitiro = idFilialeRitiro;
        this.idFilialeConsegna = idFilialeConsegna;
        this.targaVeicolo = targaVeicolo;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.prezzo = prezzo;
    }

    private String targaVeicolo;
    private LocalDate dataInizio, dataFine;
    private BigDecimal prezzo;

    /**
     * Ritorna id filiale ritiro.
     *
     *
     */
    public String getIdFilialeRitiro() {
        return idFilialeRitiro;
    }

    /**
     * Imposta id filiale ritiro.
     *
     *
     */
    public void setIdFilialeRitiro(String idFilialeRitiro) {
        this.idFilialeRitiro = idFilialeRitiro;
    }

    /**
     * Ritorna id filiale consegna.
     *
     *
     */
    public String getIdFilialeConsegna() {
        return idFilialeConsegna;
    }

    /**
     * Imposta id filiale consegna.
     *
     *
     */
    public void setIdFilialeConsegna(String idFilialeConsegna) {
        this.idFilialeConsegna = idFilialeConsegna;
    }

    /**
     * Ritorna data inizio.
     *
     *
     */
    public LocalDate getDataInizio() {
        return dataInizio;
    }

    /**
     * Imposta la data di inizio
     *
     *
     */
    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    /**
     * Ritorna data fine.
     *
     *
     */
    public LocalDate getDataFine() {
        return dataFine;
    }

    /**
     * Imposta data fine.
     *
     *
     */
    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    /**
     * Ritorna il prezzo.
     *
     *
     */
    public BigDecimal getPrezzo() {
        return prezzo;
    }

    /**
     * Imposta il  prezzo.
     *
     *
     */
    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }


    /**
     * Verifica dati contratto .
     *
     *
     */
//verifico che i dati del contratto non siano vuoti
    public boolean verificaDatiContratto(){
        return this.dataFine != null && this.dataInizio != null && this.idFilialeConsegna != null && this.idFilialeRitiro != null && this.prezzo.compareTo(BigDecimal.ZERO) > 0 && targaVeicolo != null && targaVeicolo.isBlank();
    }

    /**
     * Verifica date del contratto.
     *
     *
     */
//verifico che le date del contratto non siano nulle
    public boolean verificaDate(){
        return this.dataInizio != null && this.dataFine != null && !dataFine.isBefore(dataInizio);
    }

    /**
     * Ritorna la  durata del contratto di noleggio.
     *
     *
     */
//definisco la durata del contratto di noleggio, metto +1 siccome conteggio anche il giorno finale
    public long getDurataNoleggio(){
        if (!verificaDate()){
            return 0;
        }
        return ChronoUnit.DAYS.between(dataInizio, dataFine) + 1;
    }



}
