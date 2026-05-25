package gui;

import javax.swing.*;
import controller.Controller;
import model.TipoPatente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneClienti extends JFrame {
    private JPanel gestioneClienti;
    private JComboBox tipopatenteCombo;
    private JTextField numeroPatenteTextField;
    private JTextField codiceFiscaleTextField;
    private JTextField cognomeTextField;
    private JTextField nomeTextField;
    private JButton listaClientiButton;
    private JButton cercaClienteButton;
    private JButton aggiungiClienteButton;

    public GestioneClienti() {
        Controller controller = new Controller();
        for(TipoPatente tipo : TipoPatente.values()){
            tipopatenteCombo.addItem(tipo);
        }

        aggiungiClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeTextField.getText().trim();
                String cognome =cognomeTextField.getText().trim();
                String codiceFiscale = codiceFiscaleTextField.getText().trim();
                String numeroPatente = numeroPatenteTextField.getText().trim();
                TipoPatente tipoPatente = (TipoPatente) tipopatenteCombo.getSelectedItem();

                try {
                    controller.registraCliente(nome, cognome, codiceFiscale, tipoPatente, numeroPatente);
                    JOptionPane.showMessageDialog(null, "Cliente registrato con successo!", "Successo!", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception eccezione){
                    JOptionPane.showMessageDialog(null, "Errore!", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        listaClientiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaClienti frame = new ListaClienti();
                frame.setVisible(true);

            }
        });
        cercaClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CercaCliente frame = new CercaCliente();
                frame.setVisible(true);
            }
        });
    }
}
