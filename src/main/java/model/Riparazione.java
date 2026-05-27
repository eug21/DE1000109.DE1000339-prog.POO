package model;

import java.util.Date;

/**
 * The type Riparazione.
 */
public class Riparazione {

    private String descrizioneProblema;
    private float costoStimato;
    private float costoFinale;
    private Date dataRiparazione;
    private String targaVeicolo;


    /**
     * Gets targa veicolo.
     *
     * @return the targa veicolo
     */
    public String getTargaVeicolo() {
        return targaVeicolo;
    }

    /**
     * Sets targa veicolo.
     *
     * @param targaVeicolo the targa veicolo
     */
    public void setTargaVeicolo(String targaVeicolo) {
        this.targaVeicolo = targaVeicolo;
    }

    /**
     * Instantiates a new Riparazione.
     *
     * @param costoStimato        the costo stimato
     * @param descrizioneProblema the descrizione problema
     * @param costoFinale         the costo finale
     * @param dataRiparazione     the data riparazione
     * @param targaVeicolo        the targa veicolo
     */
    public Riparazione(float costoStimato, String descrizioneProblema, float costoFinale, Date dataRiparazione, String targaVeicolo) {
        this.costoStimato = costoStimato;
        this.descrizioneProblema = descrizioneProblema;
        this.costoFinale = costoFinale;
        this.dataRiparazione = dataRiparazione;
        this.targaVeicolo = targaVeicolo;

    }

    /**
     * Gets descrizione problema.
     *
     * @return the descrizione problema
     */
//Metodi Getter//
    public String getDescrizioneProblema() {
        return descrizioneProblema;
    }

    /**
     * Gets costo stimato.
     *
     * @return the costo stimato
     */
    public float getCostoStimato() {
        return costoStimato;
    }

    /**
     * Gets costo finale.
     *
     * @return the costo finale
     */
    public float getCostoFinale() {
        return costoFinale;
    }

    /**
     * Gets data riparazione.
     *
     * @return the data riparazione
     */
    public Date getDataRiparazione() {
        return dataRiparazione;
    }


    /**
     * Sets descrizione problema.
     *
     * @param descrizioneProblema the descrizione problema
     */
//Metodi Setter//
    public void setDescrizioneProblema(String descrizioneProblema) {
        this.descrizioneProblema = descrizioneProblema;
    }

    /**
     * Sets costo stimato.
     *
     * @param costoStimato the costo stimato
     */
    public void setCostoStimato(float costoStimato) {
        this.costoStimato = costoStimato;
    }

    /**
     * Sets costo finale.
     *
     * @param costoFinale the costo finale
     */
    public void setCostoFinale(float costoFinale) {
        this.costoFinale = costoFinale;
    }

    /**
     * Sets data riparazione.
     *
     * @param dataRiparazione the data riparazione
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
