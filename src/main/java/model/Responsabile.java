
package model;
public class Responsabile {

    private String idResponsabile;
    private String nome;
    private String cognome;
    private String mail;
    private boolean disponibile;

    public Responsabile(String idResponsabile, String nome, String cognome, String mail){
        this.idResponsabile = idResponsabile;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.disponibile = true;
    }

    //Metodi Getter//
    public  String getIdResponsabileID(){
        return idResponsabile;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public String getMail(){
        return mail;
    }

    public String isDisponibile(){
        return disponibile;
    }

    //metodi Setter//
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

    public void setDisponibile(boolean disponibile){
        this.disponibile = disponibile;
    }


    // Controllo disponibilià responsabile

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




