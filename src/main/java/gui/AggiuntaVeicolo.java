package gui;

import javax.swing.*;
import controller.Controller;
import model.Auto;
import model.Furgone;
import model.Moto;
import model.StatoVeicolo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class AggiuntaVeicolo extends JFrame {
    private JPanel aggiuntaVeicolo;
    private JTextField targaTesto;
    private JTextField marcaTesto;
    private JTextField modelloTesto;
    private JTextField tariffaTesto;
    private JTextField porteTesto;
    private JTextField cilindrataTesto;
    private JTextField capacitaTesto;
    private JButton aggiungiButton;
    private JComboBox tipoCombo;

    private Controller controller = new Controller();

    public AggiuntaVeicolo(){
        tipoCombo.addItem("Auto");
        tipoCombo.addItem("Moto");
        tipoCombo.addItem("Furgone");

        porteTesto.setVisible(false);
        cilindrataTesto.setVisible(false);
        capacitaTesto.setVisible(false);


        tipoCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String tipo = (String) tipoCombo.getSelectedItem();
                    porteTesto.setVisible(tipo.equals("Auto"));
                    cilindrataTesto.setVisible(tipo.equals("Moto"));
                    capacitaTesto.setVisible(tipo.equals("Furgone"));
            }
            });


        aggiungiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String targa = targaTesto.getText().trim();
                String marca = marcaTesto.getText().trim();
                String modello = modelloTesto.getText().trim();
                String tipo = (String) tipoCombo.getSelectedItem();

                try {
                    BigDecimal tariffa = new BigDecimal(tariffaTesto.getText().trim());
                    switch(tipo){
                        case "Auto":
                            int numeroPorte = Integer.parseInt(porteTesto.getText().trim());
                            Auto auto = new Auto(targa, modello , marca, tariffa, StatoVeicolo.Disponibile, numeroPorte);
                            controller.aggiungiVeicolo(auto);
                            break;
                        case "Moto":
                            int cilindrata = Integer.parseInt(cilindrataTesto.getText().trim());
                            Moto moto = new Moto(targa, modello, marca, tariffa, StatoVeicolo.Disponibile, cilindrata);
                            controller.aggiungiVeicolo(moto);
                            break;
                        case "Furgone":
                            float carico = Float.parseFloat(capacitaTesto.getText().trim());
                            Furgone furgone = new Furgone(targa, modello, marca, tariffa, StatoVeicolo.Disponibile, carico);
                            controller.aggiungiVeicolo(furgone);
                            break;
                    }

                    JOptionPane.showMessageDialog(null, "Veicolo aggiuinto con successo","Successo", JOptionPane.INFORMATION_MESSAGE);

                    targaTesto.setText("");
                    modelloTesto.setText("");
                    marcaTesto.setText("");
                    tariffaTesto.setText("");
                    porteTesto.setText("");
                    cilindrataTesto.setText("");
                    capacitaTesto.setText("");
                } catch (NumberFormatException eccezione){
                    JOptionPane.showMessageDialog(null, "Campo numerico non valido", "Errore", JOptionPane.ERROR_MESSAGE);

                } catch (Exception eccezione){
                    JOptionPane.showMessageDialog(null, "Errore", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
