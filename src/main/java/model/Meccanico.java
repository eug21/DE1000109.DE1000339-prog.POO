package model;

/**
 * Classe meccanico, il meccanico ripara i veicoli.
 */
public class Meccanico {

    private String idMeccanico;
    private String nome;
    private String cognome;
    private boolean disponibile;

    /**
     * Instanzia un oggetto meccanico
     *
     * @param idMeccanico  id meccanico (identificativo)
     * @param nome         nome
     * @param cognome      cognome
     */
    public Meccanico(String idMeccanico, String nome, String cognome){
        this.idMeccanico = idMeccanico;
        this.nome = nome;
        this.cognome = cognome;
        this.disponibile = true;
    }


    /**
     * Ritorna l' id meccanico.
     *
     *
     */
// Metodi Getter
    public String getIdMeccanico(){return idMeccanico;}

    /**
     * Ritorna il nome.
     *
     *
     */
    public String getNome(){return nome;}

    /**
     * Ritorna il cognome.
     *
     *
     */
    public String getCognome(){return cognome;}

    /**
     * Verifica se il meccanico è disponibile o meno.
     *
     *
     */
    public boolean isDisponibile(){
        return this.disponibile;
    }

    /**
     * Imposta il nome.
     *
     *
     */
// Metodi Setter
    public void setNome(String nome){this.nome = nome;}

    /**
     * Imposta il  cognome.
     *
     *
     */
    public void setCognome(String cognome){this.cognome = cognome;}

    /**
     * Imposta disponibile.
     *
     *
     */
    public void setDisponibile(boolean disponibile){
        this.disponibile = disponibile;
    }

    @Override
    public String toString(){
        return"Id meccanico" + idMeccanico +
        "\n"+ "nome" + nome + "\n" + "cognome"+
         cognome + "\n";

    }
}
