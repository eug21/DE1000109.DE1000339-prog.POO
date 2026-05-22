package model;
public class Meccanico {

    private String idMeccanico;
    private String nome;
    private String cognome;

    public Meccanico(String idMeccanico, String nome, String cognome){
        this.idMeccanico = idMeccanico;
        this.nome = nome;
        this.cognome = cognome;
    }

    public String IdMecc(){
        return idMeccanico;
    }

    public String nomeMecc(){
        return nome;
    }

    public String cognomeMecc(){
        return cognome;
    }

    public void newNome(String nome){
        this.nome = nome;
    }

    public void newNome(String cognome){
        this.cognome = cognome;
    }

    @Override
    public String toString(){
        return"Id meccanico" + idMeccanico +
        "\n"+ "nome" + nome + "\n" + "cognome"+
         cognome + "\n";

    }
}
