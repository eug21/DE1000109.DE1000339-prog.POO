package model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Contratto {
    private String idFilialeRitiro, idFilialeConsegna;
    private LocalDate dataInizio, dataFine;
    private float prezzo;

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

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public Contratto(String idFilialeRitiro, String idFilialeConsegna, LocalDate dataInizio, LocalDate dataFine, float prezzo) {
        this.idFilialeRitiro = idFilialeRitiro;
        this.idFilialeConsegna = idFilialeConsegna;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.prezzo = prezzo;
    }

    //verifico che i dati del contratto non siano vuoti
    public boolean verificaDatiContratto(){
        return this.dataFine != null && this.dataInizio != null && this.idFilialeConsegna != null && this.idFilialeRitiro != null && this.prezzo != 0f;
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
