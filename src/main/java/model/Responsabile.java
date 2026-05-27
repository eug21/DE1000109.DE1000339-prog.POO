
package model;

/**
 * Classe responsabile, che si occupa di gestire una filiale.
 */
public class Responsabile {

    private String idResponsabile;
    private String nome;
    private String cognome;
    private String mail;
    private boolean disponibile;

    /**
     * Istanzia un oggetto responsabile
     *
     * @param idResponsabile  id responsabile (identificativo)
     * @param nome            nome
     * @param cognome         cognome
     * @param mail            mail
     */
    public Responsabile(String idResponsabile, String nome, String cognome, String mail){
        this.idResponsabile = idResponsabile;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.disponibile = true;
    }

    /**
     * Ritorna  id responsabile.
     *
     *
     */
//Metodi Getter//
    public  String getIdResponsabileID(){
        return idResponsabile;
    }

    /**
     * Ritorna il nome.
     *
     *
     */
    public String getNome(){
        return nome;
    }

    /**
     * Ritorna il cognome.
     *
     *
     */
    public String getCognome(){
        return cognome;
    }

    /**
     * Ritorna la mail
     *
     *
     */
    public String getMail(){
        return mail;
    }

    /**
     * Verifica se il responsabile è disponibile.
     *
     *
     */
    public boolean isDisponibile(){
        return disponibile;
    }

    /**
     * Imposta il nome.
     *
     *
     */
//metodi Setter//
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Imposta il cognome.
     *
     *
     */
    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    /**
     * Imposta la mail.
     *
     *
     */
    public void setMail(String mail){
        this.mail = mail;
    }

    /**
     * Imposta lo stato disponibile.
     *
     *
     */
    public void setDisponibile(boolean disponibile){
        this.disponibile = disponibile;
    }




    @Override
    public String toString(){
        return"Id responsabile" + idResponsabile +
        "\n"+ "Nome" + nome + "\n" + "Cognome" +
        cognome + "\n" + "Mail" + mail;
    }
}




