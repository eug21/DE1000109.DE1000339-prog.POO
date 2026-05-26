package model;

import java.math.BigDecimal;

public class Furgone extends Veicolo {

    private  float capacitaCarico;

    public Furgone(String targa, String modello, String marca, BigDecimal tariffeDie,
     StatoVeicolo statoVeicolo, float capacitaCarico) {
        super(targa, modello, marca, tariffeDie, statoVeicolo);
        this.capacitaCarico = capacitaCarico;
    }

    //Metodi Getter
    public float getCapacitaCarico(){return capacitaCarico;}

    //Metodi Setter
    public void setCapacitaCarico(float capacitaCarico){
        this.capacitaCarico = capacitaCarico;
    }

    public boolean verificaCapacitaCarico(){
        return  this.capacitaCarico > 0;
    }


    @Override
    public  String toString(){
        return "Furgone [Targa=" + getTarga()
        +", Modello=" + getModello()
        +", Marca=" + getMarca()
        +", tariffaDie=" + getTariffaDie()
        +", StatoVeicolo=" + getStatoVeicolo()
        +", capacitaCarico=" + capacitaCarico + "]" ;
    }
}
