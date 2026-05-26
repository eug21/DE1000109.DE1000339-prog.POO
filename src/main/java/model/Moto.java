package model;

import java.math.BigDecimal;

public class Moto extends Veicolo {

    private int cilindrata;

    public Moto(String targa, String modello, String marca, BigDecimal tarriffaDie, StatoVeicolo statoVeicolo,
    int cilindrata){
        super(targa, modello, marca, tarriffaDie, statoVeicolo);
        this.cilindrata = cilindrata;
    }

    //Metodi Getter
    public  int getCilindrata(){
        return cilindrata;
    }

    //Metodi setter
    public  void setCilindrata(int cilindrata){this.cilindrata = cilindrata;}

    //Verifica che la cilindrata sia valida
    public boolean verificaCilindrata(){
        return  verificaCilindrata() && verificaCilindrata();
    }

    @Override
    public  String toString(){
        return "Moto:[targa=" + getTarga()
        + ", Modello=" + getModello()
        + ", Marca=" + getMarca()
        +", TariffaDie=" + getTariffaDie()
        + ", StatoVeicolo=" + getStatoVeicolo()
        + ", Cilindrata="+ cilindrata + "]";

    }
}
