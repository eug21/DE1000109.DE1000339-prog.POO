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
                String codice = txtCodice.getText().trim();
                String via = txtVia.getText().trim();
                String citta = txtCitta.getText().trim();
                String cap = txtCAP.getText().trim();
                String telefono = txtTel.getText().trim();

                try{
                    controller.aggiungiFiliale(codice, via, citta, cap, telefono);
                    JOptionPane.showMessageDialog(null, "Filiale aggiunta con successo! ", "Successo", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (DatiFilialeNonValidaException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Errore dati.", JOptionPane.ERROR_MESSAGE);
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Errore inatteso. ", JOptionPane.ERROR_MESSAGE);
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
    }

}


