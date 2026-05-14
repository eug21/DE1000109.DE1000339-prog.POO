package model;

import java.math.BigDecimal;

public class Auto extends Veicolo{

    private int numeroPorte;

    public Auto(String targa, String modello, String marca, BigDecimal tariffaDie, StatoVeicolo statoVeicolo, int numeroPorte) {
        super(targa, modello, marca, tariffaDie, statoVeicolo);
        this.numeroPorte = numeroPorte;
    }

    public int getNumeroPorte() {
        return numeroPorte;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    public boolean verificaNumeroPorte(){
        return this.numeroPorte > 0;
    }

    public boolean verificaAutoValida(){
        return verificaDatiVeicolo() && verificaNumeroPorte();
    }

    @Override
    public String toString(){
        return "Auto  return \"Auto [targa=\" + getTarga()\n" +
                "            + \", modello=\" + getModello()\n" +
                "            + \", marca=\" + getMarca()\n" +
                "            + \", tariffaDie=\" + getTariffaDie()\n" +
                "            + \", statoVeicolo=\" + getStatoVeicolo()\n" +
                "            + \", numeroPorte=\" + numeroPorte + \"]\"";
    }
}
