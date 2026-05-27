package model;

/**
 * Classe Cliente, ovvero la persona che viene registrata per il noleggio di un veicolo
 */
public class Cliente
{
    private String nome, cognome, codiceFiscale, numeroPatente;
    private TipoPatente tipoPatente;

    /**
     * Crea un oggetto cliente
     *
     * @param nome           nome
     * @param cognome        cognome
     * @param codiceFiscale  codice fiscale
     * @param tipoPatente    tipo patente (tra quelle ammesse)
     * @param numeroPatente  numero patente (identificativo a sistema)
     */
    public Cliente (String nome, String cognome, String codiceFiscale, TipoPatente tipoPatente, String numeroPatente)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.tipoPatente = tipoPatente;
        this.numeroPatente = numeroPatente;
    }

    /**
     * Restituisce il nome.
     *
     *
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce il cognome.
     *
     *
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Restituisce il codice fiscale.
     *
     *
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Restituisce il tipo patente del cliente.
     *
     *
     */
    public TipoPatente getTipoPatente() {
        return tipoPatente;
    }

    /**
     * Restituisce il numero patente.
     *
     *
     */
    public String getNumeroPatente() {
        return numeroPatente;
    }

    /**
     * Imposta il nome.
     *
     *
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Imposta il cognome.
     *
     *
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Imposta il  codice fiscale.
     *
     *
     */
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    /**
     * Imposta il tipo patente.
     *
     *
     */
    public void setTipoPatente(TipoPatente tipoPatente) {
        this.tipoPatente = tipoPatente;
    }

    /**
     * Imposta il numero patente.
     *
     *
     */
    public void setNumeroPatente(String numeroPatente) {
        this.numeroPatente = numeroPatente;
    }

    /**
     * Verifica che il tipo di patente del cliente sia uno di quelli ammessi a sistema.
     *
     *
     */
//verifico che il cliente abbia una patente ammessa nel sistema, altrimenti non può noleggiare
    public boolean verificaPatente(){
        return this.tipoPatente.equals(TipoPatente.A) || this.tipoPatente.equals(TipoPatente.A2) || this.tipoPatente.equals(TipoPatente.A1) || this.tipoPatente.equals(TipoPatente.B1) || this.tipoPatente.equals(TipoPatente.B);
    }

    /**
     * Verifica se la patente passata come parametro  è effettivamente quella del cliente registrato.
     *
     *
     *
     */
//con una patente passata come parametro, ne faccio una verifica con quella del cliente
    public boolean confrontaPatente(TipoPatente patente){
        return this.tipoPatente.equals(patente);
    }

    //verifica corretta registrazione del cliente mediante controllo del numero di patente che usiamo come PK

    /**
     * Verifica che i dati della registrazioni siano validi e non nulli
     *
     *
     */
    public boolean verificaRegistrazione(){
        return this.numeroPatente != null && this.tipoPatente != null && this.codiceFiscale != null;
    }
}
