package model;

/**
 * Classe filiale, dove vengono noleggiati i veicoli, gestita da un responsabile e dove vi ci lavora un meccanico.
 */
public class Filiale {
    private String codiceFiliale, via, citta, cap, numeroTelefono;

    /**
     * Istanzia un oggetto filiale
     *
     * @param codiceFiliale   codice filiale (identificativo)
     * @param via             via
     * @param citta           citta
     * @param cap             cap
     * @param numeroTelefono  numero telefono
     */
    public Filiale(String codiceFiliale, String via, String citta, String cap, String numeroTelefono) {
        this.codiceFiliale = codiceFiliale;
        this.via = via;
        this.citta = citta;
        this.cap = cap;
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * Ritorna codice filiale.
     *
     *
     */
    public String getCodiceFiliale() {
        return codiceFiliale;
    }

    /**
     * Imposta  codice filiale.
     *
     *
     */
    public void setCodiceFiliale(String codiceFiliale) {
        this.codiceFiliale = codiceFiliale;
    }

    /**
     * Ritornia la via.
     *
     *
     */
    public String getVia() {
        return via;
    }

    /**
     * Imposta la via.
     *
     *
     */
    public void setVia(String via) {
        this.via = via;
    }

    /**
     * Ritorna la citta.
     *
     *
     */
    public String getCitta() {
        return citta;
    }

    /**
     * Imposta la citta.
     *
     *
     */
    public void setCitta(String citta) {
        this.citta = citta;
    }

    /**
     * Ritorna il  cap (codice avviamento postale).
     *
     *
     */
    public String getCap() {
        return cap;
    }

    /**
     * Imposta il cap (codice avviamento postale).
     *
     *
     */
    public void setCap(String cap) {
        this.cap = cap;
    }

    /**
     * Ritorna il numero di telefono.
     *
     *
     */
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * Imposta  il  numero di telefono.
     *
     *
     */
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * Verifica che i campi della filiale non siano nulli
     *
     *
     */
// verifico che i dati della filiale non siano campi vuoti
    public boolean verificaDatiFiliale(){
        return this.codiceFiliale != null && this.numeroTelefono != null && this.citta != null && this.via != null && this.cap != null;
    }

    /**
     * Restituisce l'indirizzo completo della filiale.
     *
     *
     */
// restituisco i campi dell'indirizzo della filiale in maniera completa
    public String getIndirizzoFiliale(){
        return via + citta +  cap;
    }
}
