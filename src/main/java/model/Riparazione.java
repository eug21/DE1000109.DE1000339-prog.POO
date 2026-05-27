package model;

import java.util.Date;

/**
 * Classe riparazioe, classe associativa tra meccanico e veicolo, si compone con la descrizione del problema, il costo e la data.
 */
public class Riparazione {

    private String descrizioneProblema;
    private float costoStimato;
    private float costoFinale;
    private Date dataRiparazione;
    private String targaVeicolo;


    /**
     * Ritorna la targa veicolo.
     *
     *
     */
    public String getTargaVeicolo() {
        return targaVeicolo;
    }

    /**
     * Imposta la targa veicolo.
     *
     *
     */
    public void setTargaVeicolo(String targaVeicolo) {
        this.targaVeicolo = targaVeicolo;
    }

    /**
     * Istanzia una riparazione
     *
     * @param costoStimato         costo stimato
     * @param descrizioneProblema  descrizione problema
     * @param costoFinale          costo finale
     * @param dataRiparazione      data riparazione
     * @param targaVeicolo         targa veicolo
     */
    public Riparazione(float costoStimato, String descrizioneProblema, float costoFinale, Date dataRiparazione, String targaVeicolo) {
        this.costoStimato = costoStimato;
        this.descrizioneProblema = descrizioneProblema;
        this.costoFinale = costoFinale;
        this.dataRiparazione = dataRiparazione;
        this.targaVeicolo = targaVeicolo;

    }

    /**
     * Ritorna la descrizione problema.
     *
     *
     */
//Metodi Getter//
    public String getDescrizioneProblema() {
        return descrizioneProblema;
    }

    /**
     * Ritorna il  costo stimato.
     *
     *
     */
    public float getCostoStimato() {
        return costoStimato;
    }

    /**
     * Ritorna il costo finale.
     *
     *
     */
    public float getCostoFinale() {
        return costoFinale;
    }

    /**
     * Ritorna la data riparazione.
     *
     *
     */
    public Date getDataRiparazione() {
        return dataRiparazione;
    }


    /**
     * Imposta la  descrizione problema.
     *
     *
     */
//Metodi Setter//
    public void setDescrizioneProblema(String descrizioneProblema) {
        this.descrizioneProblema = descrizioneProblema;
    }

    /**
     * Imposta il costo stimato.
     *
     *
     */
    public void setCostoStimato(float costoStimato) {
        this.costoStimato = costoStimato;
    }

    /**
     * Imposta il costo finale.
     *
     * @param costoFinale the costo finale
     */
    public void setCostoFinale(float costoFinale) {
        this.costoFinale = costoFinale;
    }

    /**
     * Imposta la data riparazione.
     *
     *
     */
    public void setDataRiparazione(Date dataRiparazione) {
        this.dataRiparazione = dataRiparazione;
    }


    @Override
    public String toString() {
        return "Descrizione problema:" + descrizioneProblema + "\n" +
                "Costo stimato:" + costoStimato + "\n" +
                "Data riparazione:" + dataRiparazione + "\n" +
                "costo finale:" + costoFinale + "\n" +
                " targa:" + targaVeicolo + "\n";
    }
}
