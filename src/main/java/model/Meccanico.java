package model;
public class Meccanico {

    private String idMeccanico;
    private String nome;
    private String cognome;
    private boolean disponibile;

    public Meccanico(String idMeccanico, String nome, String cognome){
        this.idMeccanico = idMeccanico;
        this.nome = nome;
        this.cognome = cognome;
        this.disponibile = true;
    }


    // Metodi Getter
    public String getIdMeccanico(){return idMeccanico;}

    public String getNome(){return nome;}

    public String getCognome(){return cognome;}

    public boolean isDisponibile(){
        return this.disponibile;
    }

    // Metodi Setter
    public void setNome(String nome){this.nome = nome;}

    public void setCognome(String cognome){this.cognome = cognome;}

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
