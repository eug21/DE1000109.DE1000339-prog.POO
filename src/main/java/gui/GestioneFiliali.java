package gui;

import controller.Controller;
import exception.DatiFilialeNonValidaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class GestioneFiliali extends JFrame {
    private JTextField txtCodice;
    private JTextField txtVia;
    private JTextField txtCitta;
    private JTextField txtCAP;
    private JTextField txtTel;
    private JButton aggiungiFilialeButton;
    private JPanel gestioneFiliali;
    private JButton listaFilialiButton;
    private JButton cercaFilialeButton;


    public GestioneFiliali() {
        setTitle("Gestione Filiali");
        setContentPane(gestioneFiliali);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        Controller controller = new Controller();

        aggiungiFilialeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codice = txtCodice.getText().trim().toUpperCase();
                String via = txtVia.getText().trim();
                String citta = txtCitta.getText().trim();
                String cap = txtCAP.getText().trim();
                String telefono = txtTel.getText().trim();

                if(codice.isEmpty() || via.isEmpty() || citta.isEmpty() || cap.isEmpty() || telefono.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Compila i campi", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!codice.matches("^[A-Z0-9]+$")) {
                    JOptionPane.showMessageDialog(null, "Il codice filiale deve contenere solo lettere e numeri.", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(telefono.matches("^[0-9]{9,11}$")){
                    JOptionPane.showMessageDialog(null, "Numero telefono non valido", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(!cap.matches("^[0-9]{5}$")){
                    JOptionPane.showMessageDialog(null, "Il CAP deve contenere 5 numeri", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try{
                    controller.aggiungiFiliale(codice, via, citta, cap, telefono);
                    JOptionPane.showMessageDialog(null, "Filiale aggiunta con successo! ", "Successo", JOptionPane.INFORMATION_MESSAGE);
                    txtCodice.setText("");
                    txtVia.setText("");
                    txtCAP.setText("");
                    txtTel.setText("");
                    txtCAP.setText("");
                    txtCitta.setText("");
                }
                catch (DatiFilialeNonValidaException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Errore dati.", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception eccezione){
                    // prendo l' errore dal trigger postgres
                    String messaggioErrore = eccezione.getMessage();
                    if(eccezione.getCause() != null){
                        messaggioErrore = eccezione.getCause().getMessage();
                    }
                    JOptionPane.showMessageDialog(null,messaggioErrore,  "Errore in fase di inserimento", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        listaFilialiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaFiliali frame = new ListaFiliali();
                frame.setVisible(true);
            }
        });
        cercaFilialeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cercaFiliale frame = new cercaFiliale();
                frame.setVisible(true);
            }
        });
    }

}


