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

    private Controller controller = new Controller();

    public CercaPerFiliale() {
        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codice = codiceFilialeTextField.getText().trim();
                if(codice.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Inserire un codice filiale", "Errore", JOptionPane.ERROR_MESSAGE);
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
                    Object [][] righe = null; // da fare

                    tabContratti.setModel(new DefaultTableModel(righe, colonne));
                } catch (FilialeNonTrovataException eccezione){
                    JOptionPane.showMessageDialog(null, "Filiale non trovata", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
