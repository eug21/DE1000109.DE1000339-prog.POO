package model;

public class Cliente
{
    private String nome, cognome, codiceFiscale, numeroPatente;
    private TipoPatente tipoPatente;

    public Cliente (String nome, String cognome, String codiceFiscale, TipoPatente tipoPatente, String numeroPatente)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.tipoPatente = tipoPatente;
        this.numeroPatente = numeroPatente;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public TipoPatente getTipoPatente() {
        return tipoPatente;
    }

    public String getNumeroPatente() {
        return numeroPatente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public void setTipoPatente(TipoPatente tipoPatente) {
        this.tipoPatente = tipoPatente;
    }

    public void setNumeroPatente(String numeroPatente) {
        this.numeroPatente = numeroPatente;
    }

    //verifico che il cliente abbia una patente ammessa nel sistema, altrimenti non può noleggiare
    public boolean verificaPatente(){
        return this.tipoPatente.equals(TipoPatente.A) || this.tipoPatente.equals(TipoPatente.A2) || this.tipoPatente.equals(TipoPatente.A1) || this.tipoPatente.equals(TipoPatente.B1) || this.tipoPatente.equals(TipoPatente.B);
    }

    //con una patente passata come parametro, ne faccio una verifica con quella del cliente
    public boolean confrontaPatente(TipoPatente patente){
        return this.tipoPatente.equals(patente);
    }

    //verifica corretta registrazione del cliente mediante controllo del numero di patente che usiamo come PK

    public boolean verificaRegistrazione(){
        return this.numeroPatente != null && this.tipoPatente != null && this.codiceFiscale != null;
    }
}
