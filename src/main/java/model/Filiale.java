package model;

public class Filiale {
    private String codiceFiliale, via, citta, cap, numeroTelefono;

    public Filiale(String codiceFiliale, String via, String citta, String cap, String numeroTelefono) {
        this.codiceFiliale = codiceFiliale;
        this.via = via;
        this.citta = citta;
        this.cap = cap;
        this.numeroTelefono = numeroTelefono;
    }

    public String getCodiceFiliale() {
        return codiceFiliale;
    }

    public void setCodiceFiliale(String codiceFiliale) {
        this.codiceFiliale = codiceFiliale;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    // verifico che i dati della filiale non siano campi vuoti
    public boolean verificaDatiFiliale(){
        return this.codiceFiliale != null && this.numeroTelefono != null && this.citta != null && this.via != null && this.cap != null;
    }

    // restituisco i campi dell'indirizzo della filiale in maniera completa
    public String getIndirizzoFiliale(){
        return via + citta +  cap;
    }

    //eventuale modifica del numero di telefono
    public void modificaTelefono(String telefono) {
        if(telefono == null){
            return;
        }
        this.numeroTelefono = telefono;
    }



}
