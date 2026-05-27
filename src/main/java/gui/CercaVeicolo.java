package gui;

import controller.Controller;
import exception.VeicoloNonTrovatoException;
import model.StatoVeicolo;
import model.Veicolo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CercaVeicolo extends JFrame {
    private JPanel cercaVeicolo;
    private JTextField testoTargaTextField;
    private JTextField testoMarcaTextField;
    private JTextField testoModelloTextField;
    private JTextField testoTariffaTextField;
    private JComboBox comboStato;
    private JButton cercaButton;
    private JButton aggiornaStatoButton;

    private Controller controller = new Controller();

    public CercaVeicolo(){
        setTitle("Cerca un veicolo");
        setContentPane(cercaVeicolo);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        testoMarcaTextField.setVisible(false);
        testoModelloTextField.setVisible(false);
        testoTariffaTextField.setVisible(false);
        comboStato.setVisible(false);
        aggiornaStatoButton.setVisible(false);

        comboStato.addItem(StatoVeicolo.Disponibile);
        comboStato.addItem(StatoVeicolo.Manutenzione);
        comboStato.addItem(StatoVeicolo.Noleggiato);


        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String targa = testoTargaTextField.getText().trim();

                try{
                    Veicolo veicolo =  controller.cercaTarga(targa);

                    testoMarcaTextField.setText(veicolo.getMarca());
                    testoModelloTextField.setText(veicolo.getModello());
                    testoTariffaTextField.setText(veicolo.getTariffaDie().toString());
                    comboStato.setSelectedItem(veicolo.getStatoVeicolo());

                    testoMarcaTextField.setVisible(true);
                    testoModelloTextField.setVisible(true);
                    testoTariffaTextField.setVisible(true);
                    comboStato.setVisible(true);
                    aggiornaStatoButton.setVisible(true);

                } catch (VeicoloNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null, "Errore", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        aggiornaStatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String targa = testoTargaTextField.getText().trim();
                StatoVeicolo nuovoStato = (StatoVeicolo) comboStato.getSelectedItem();

                try{
                    controller.aggiornaStatoVeicolo(targa, nuovoStato);
                    JOptionPane.showMessageDialog(null, "Stato veicolo aggiornato", "Successo", JOptionPane.INFORMATION_MESSAGE);
                } catch (VeicoloNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null, "Veicolo non trovato", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
