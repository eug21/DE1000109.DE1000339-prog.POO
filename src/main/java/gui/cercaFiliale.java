package gui;

import javax.swing.*;
import controller.Controller;
import exception.DatiFilialeNonValidaException;
import exception.FilialeNonTrovataException;
import model.Filiale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class cercaFiliale {
    private JPanel cercaFiliale;
    private JTextField testoCodiceTextField;
    private JButton cercaButton;
    private JTextField testoViaTextField;
    private JTextField testoCittaTextField;
    private JTextField testoCAPTextField;
    private JTextField testoTelefonoTextField;
    private JButton salvaModificheButton;

    public cercaFiliale(){
        Controller controller = new Controller();
        testoCAPTextField.setVisible(false);
        testoCittaTextField.setVisible(false);
        testoTelefonoTextField.setVisible(false);
        testoViaTextField.setVisible(false);
        salvaModificheButton.setVisible(false);

        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codice = testoCodiceTextField.getText().trim();
                try{
                    Filiale filiale = controller.cercaConIdFiliale(codice);
                    testoCAPTextField.setText(filiale.getCap());
                    testoCittaTextField.setText(filiale.getCitta());
                    testoViaTextField.setText(filiale.getVia());
                    testoTelefonoTextField.setText(filiale.getNumeroTelefono());

                    testoCAPTextField.setVisible(true);
                    testoCittaTextField.setVisible(true);
                    testoTelefonoTextField.setVisible(true);
                    testoViaTextField.setVisible(true);
                    salvaModificheButton.setVisible(true);
                } catch (FilialeNonTrovataException eccezione){
                    JOptionPane.showMessageDialog(null, eccezione.getMessage(), "La filiale non esiste", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        salvaModificheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codice = testoCodiceTextField.getText().trim();
                String via = testoViaTextField.getText().trim();
                String citta = testoCittaTextField.getText().trim();
                String cap = testoCAPTextField.getText().trim();
                String telefono = testoTelefonoTextField.getText().trim();

                try{
                    controller.modificaDatiFiliale(codice, via, cap, citta, telefono, codice);
                    JOptionPane.showMessageDialog(null, "Dati modificati con successo!", "Successo", JOptionPane.INFORMATION_MESSAGE);
                } catch (DatiFilialeNonValidaException eccezione){
                    JOptionPane.showMessageDialog(null, "I dati inseriti non sono validi", "Errore", JOptionPane.ERROR_MESSAGE);
                } catch (FilialeNonTrovataException eccezione){
                    JOptionPane.showMessageDialog(null, "Filiale non trovata", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
