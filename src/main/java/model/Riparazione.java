package model;

import java.util.Date;

public class Riparazione {

    private String descrizioneProblema;
    private float costoStimato;
    private float costoFinale;
    private Date dataRiparazione;
    private Veicolo veicolo;
    private Meccanico meccanico;


    public Riparazione(float costoStimato, String descrizioneProblema, float costoFinale, Date dataRiparazione, Veicolo veicolo, Meccanico meccanico) {
        this.costoStimato = costoStimato;
        this.descrizioneProblema = descrizioneProblema;
        this.costoFinale = costoFinale;
        this.dataRiparazione = dataRiparazione;
        this.veicolo = veicolo;
        this.meccanico = meccanico;
    }

    //Metodi Getter//
    public String getDescrizioneProblema() {
        return descrizioneProblema;
    }

    public float getCostoStimato() {
        return costoStimato;
    }

    public float getCostoFinale() {
        return costoFinale;
    }

    public Date getDataRiparazione() {
        return dataRiparazione;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public Meccanico getMeccanico() {
        return meccanico;
    }

    //Metodi Setter//
    public void setDescrizioneProblema(String descrizioneProblema) {
        this.descrizioneProblema = descrizioneProblema;
    }

    public void setCostoStimato(float costoStimato) {
        this.costoStimato = costoStimato;
    }

    public void setCostoFinale(float costoFinale) {
        this.costoFinale = costoFinale;
    }

    public void setDataRiparazione(Date dataRiparazione) {
        this.dataRiparazione = dataRiparazione;
    }


    @Override
    public String toString() {
        return "Descrizione problema:" + descrizioneProblema + "\n" +
                "Costo stimato:" + costoStimato + "\n" +
                "Data riparazione:" + dataRiparazione + "\n" +
                "costo finale:" + costoFinale + "\n" +
                " veicolo:" + veicolo + "\n" +
                "Meccanico:" + meccanico;
    }
}
