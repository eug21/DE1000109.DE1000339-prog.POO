
package model;

/**
 * The type Responsabile.
 */
public class Responsabile {

    private String idResponsabile;
    private String nome;
    private String cognome;
    private String mail;
    private boolean disponibile;

    /**
     * Instantiates a new Responsabile.
     *
     * @param idResponsabile the id responsabile
     * @param nome           the nome
     * @param cognome        the cognome
     * @param mail           the mail
     */
    public Responsabile(String idResponsabile, String nome, String cognome, String mail){
        this.idResponsabile = idResponsabile;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.disponibile = true;
    }

    /**
     * Get id responsabile id string.
     *
     * @return the string
     */
//Metodi Getter//
    public  String getIdResponsabileID(){
        return idResponsabile;
    }

    /**
     * Get nome string.
     *
     * @return the string
     */
    public String getNome(){
        return nome;
    }

    /**
     * Get cognome string.
     *
     * @return the string
     */
    public String getCognome(){
        return cognome;
    }

    /**
     * Get mail string.
     *
     * @return the string
     */
    public String getMail(){
        return mail;
    }

    /**
     * Is disponibile boolean.
     *
     * @return the boolean
     */
    public boolean isDisponibile(){
        return disponibile;
    }

    /**
     * Set nome.
     *
     * @param nome the nome
     */
//metodi Setter//
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Set cognome.
     *
     * @param cognome the cognome
     */
    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    /**
     * Set mail.
     *
     * @param mail the mail
     */
    public void setMail(String mail){
        this.mail = mail;
    }

    /**
     * Set disponibile.
     *
     * @param disponibile the disponibile
     */
    public void setDisponibile(boolean disponibile){
        this.disponibile = disponibile;
    }


    // Controllo disponibilià responsabile

    /**
     * Accetta incarico boolean.
     *
     * @return the boolean
     */
    public  boolean accettaIncarico(){
        return disponibile;
    }

    @Override
    public String toString(){
        return"Id responsabile" + idResponsabile +
        "\n"+ "Nome" + nome + "\n" + "Cognome" +
        cognome + "\n" + "Mail" + mail;
    }
}




