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
        setTitle("Gestione Clienti");
        setContentPane(gestioneClienti);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        Controller controller = new Controller();
        for(TipoPatente tipo : TipoPatente.values()){
            tipopatenteCombo.addItem(tipo);
        }

        aggiungiClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeTextField.getText().trim();
                String cognome =cognomeTextField.getText().trim();
                String codiceFiscale = codiceFiscaleTextField.getText().trim().toUpperCase();
                String numeroPatente = numeroPatenteTextField.getText().trim().toUpperCase();
                TipoPatente tipoPatente = (TipoPatente) tipopatenteCombo.getSelectedItem();
                if(nome.isEmpty() || cognome.isEmpty() || codiceFiscale.isEmpty() || numeroPatente.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Compila i campi.", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!codiceFiscale.matches("^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$")) {
                    JOptionPane.showMessageDialog(null, "Formato Codice Fiscale non valido", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!numeroPatente.matches("^[A-Z0-9]{9,10}$")) {
                    JOptionPane.showMessageDialog(null, "Numero patente non valido, usa il formato europeo.", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    controller.registraCliente(nome, cognome, codiceFiscale, tipoPatente, numeroPatente);
                    JOptionPane.showMessageDialog(null, "Cliente registrato con successo!", "Successo!", JOptionPane.INFORMATION_MESSAGE);
                    nomeTextField.setText("");
                    cognomeTextField.setText("");
                    codiceFiscaleTextField.setText("");
                    numeroPatenteTextField.setText("");

                } catch (Exception eccezione){
                    //recupero trigger
                    String messaggioErrore = eccezione.getMessage();
                    if(eccezione.getCause() != null){
                        messaggioErrore = eccezione.getCause().getMessage();
                    }
                    JOptionPane.showMessageDialog(null, "Errore!", messaggioErrore, JOptionPane.ERROR_MESSAGE);
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
