package model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.math.BigDecimal;

public class Contratto {
    private String idFilialeRitiro;
    private String idFilialeConsegna;

    public String getTargaVeicolo() {
        return targaVeicolo;
    }

    public void setTargaVeicolo(String targaVeicolo) {
        this.targaVeicolo = targaVeicolo;
    }

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

    public String getIdFilialeRitiro() {
        return idFilialeRitiro;
    }

    public void setIdFilialeRitiro(String idFilialeRitiro) {
        this.idFilialeRitiro = idFilialeRitiro;
    }

    public String getIdFilialeConsegna() {
        return idFilialeConsegna;
    }

    public void setIdFilialeConsegna(String idFilialeConsegna) {
        this.idFilialeConsegna = idFilialeConsegna;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }



    //verifico che i dati del contratto non siano vuoti
    public boolean verificaDatiContratto(){
        return this.dataFine != null && this.dataInizio != null && this.idFilialeConsegna != null && this.idFilialeRitiro != null && this.prezzo.compareTo(BigDecimal.ZERO) > 0 && targaVeicolo != null && targaVeicolo.isBlank();
    }

    //verifico che le date del contratto non siano nulle
    public boolean verificaDate(){
        return this.dataInizio != null && this.dataFine != null && !dataFine.isBefore(dataInizio);
    }

    //definisco la durata del contratto di noleggio, metto +1 siccome conteggio anche il giorno finale
    public long getDurataNoleggio(){
        if (!verificaDate()){
            return 0;
        }
        return ChronoUnit.DAYS.between(dataInizio, dataFine) + 1;
    }



}
