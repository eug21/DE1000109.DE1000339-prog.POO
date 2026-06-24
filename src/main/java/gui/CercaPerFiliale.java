package gui;

import controller.Controller;
import exception.FilialeNonTrovataException;
import model.Contratto;
import model.Filiale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CercaPerFiliale extends JFrame{
    private JPanel cercaPerFiliale;
    private JTextField codiceFilialeTextField;
    private JButton cercaButton;
    private JScrollPane scroll;
    private JTable tabContratti;

    private Controller controller; 

    public CercaPerFiliale(Controller controllerHome) {
        this.controller = controllerHome;

        setTitle("Cerca contratti per filiale");
        setContentPane(cercaPerFiliale);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codice = codiceFilialeTextField.getText().trim().toUpperCase();
                if(codice.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Inserire un codice filiale", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!codice.matches("^[A-Z0-9]+$")) {
                    JOptionPane.showMessageDialog(null, "Il codice filiale deve contenere solo lettere e numeri.", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }


                try{
                    Filiale filiale = controller.cercaConIdFiliale(codice);
                    List< Contratto > contratti = controller.getContrattiFiliale(filiale);

                    if(contratti == null || contratti.isEmpty()){
                        JOptionPane.showMessageDialog(null, "La filiale non presenta contratti", "" , JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String [] colonne = {"Filiale Ritiro", "Targa", "Data Inizio", "Data Fine", "Prezzo"};
                    DefaultTableModel modello = new DefaultTableModel(null, colonne);
                    for (Contratto c : contratti){
                        modello.addRow(new Object[]{
                                c.getIdFilialeRitiro(),
                                c.getIdFilialeConsegna(),
                                c.getTargaVeicolo(),
                                c.getDataInizio(),
                                c.getDataFine(),
                                c.getPrezzo() + "€"
                        });
                    }
                    tabContratti.setModel(modello);
                } catch (FilialeNonTrovataException eccezione){
                    JOptionPane.showMessageDialog(null, "Filiale non trovata", "Errore", JOptionPane.ERROR_MESSAGE);
                } catch (Exception eccezione){
                    // prendo l' errore dal trigger postgres
                    String messaggioErrore = eccezione.getMessage();
                    if(eccezione.getCause() != null){
                        messaggioErrore = eccezione.getCause().getMessage();
                    }
                    JOptionPane.showMessageDialog(null,"Errore",  "Errore in fase di inserimento", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
