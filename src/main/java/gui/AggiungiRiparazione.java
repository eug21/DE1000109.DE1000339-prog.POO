package gui;

import controller.Controller;
import exception.DatiRiparazioneNonValidiException;
import model.Riparazione;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class AggiungiRiparazione extends JFrame {
    private JPanel aggiungi;
    private JTextField targaTextField;
    private JTextField problemaTextField;
    private JTextField stimaTextField;
    private JTextField prezzpTextField;
    private JTextField dataTextField;
    private JButton aggiungiButton;

    private Controller controller = new Controller();

    public AggiungiRiparazione(){
        setTitle("Aggiungi una riparazione");
        setContentPane(aggiungi);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        aggiungiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String targa = targaTextField.getText().trim();
                String problema = problemaTextField.getText().trim();
                Float prezzo = Float.valueOf(prezzpTextField.getText().trim());
                String dataTesto = dataTextField.getText().trim();
                SimpleDateFormat formatter = new SimpleDateFormat();
                Date data = null;
                try {
                    data = formatter.parse(dataTesto);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    Riparazione riparazione  = controller.aggiungiRiparazione(problema, prezzo, data, prezzo, targa);
                    JOptionPane.showMessageDialog(null, "Riparazione aggiunta con successo", "Successo", JOptionPane.INFORMATION_MESSAGE);
                    targaTextField.setText("");
                    problemaTextField.setText("");
                    prezzpTextField.setText("");
                    dataTextField.setText("");

                } catch (DatiRiparazioneNonValidiException eccezione){
                    JOptionPane.showMessageDialog(null, "Dati non validi", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
