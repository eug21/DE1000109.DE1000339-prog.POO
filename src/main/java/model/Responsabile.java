
package model;
public class Responsabile {

    private String idResponsabile;
    private String nome;
    private String cognome;
    private String mail;

    public Responsabile(String idResponsabile, String nome, String cognome, String mail){
        this.idResponsabile = idResponsabile;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
    }

    public  String IdResp(){
        return idResponsabile;
    }

    public String NomeResp(){
        return nome;
    }

    public String CognResp(){
        return cognome;
    }

    public String MailResp(){
        return mail;
    }

    public void NewNome(String nome){
        this.nome = nome;
    }

    public void NewCognome(String cognome){
        this.cognome = cognome;
    }

    public void NewMail(String mail){
        this.mail = mail;
    }


    @Override
    public String toString(){
        return"Id responsabile" + idResponsabile +
        "\n"+ "Nome" + nome + "\n" + "Cognome" +
        cognome + "\n" + "Mail" + mail;
    }
}




