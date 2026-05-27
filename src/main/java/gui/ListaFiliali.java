package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import controller.Controller ;
import exception.FilialeNonTrovataException;

public class ListaFiliali extends  JFrame{
    private JPanel listaFiliali;
    private JButton aggiornaListaButton;
    private JTable filialiTable;
    private JButton eliminaSelezionataButton;

    public ListaFiliali() {
        setTitle("Lista filiali");
        setContentPane(listaFiliali);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
         Controller controller = new Controller();
        aggiornaListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] colonne = {"CODICE", "VIA", "CITTA", "CAP", "TELEFONO"};
                Object[] [] dati = {};
                filialiTable.setModel(new DefaultTableModel(dati, colonne));
            }
        });

        eliminaSelezionataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rigaSelezionata = filialiTable.getSelectedRow();
                if(rigaSelezionata == -1){
                    JOptionPane.showMessageDialog(null, "Seleziona una riga da eliminare", "Attenzione" ,JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String codice  = (String) filialiTable.getValueAt(rigaSelezionata, 0);
                int conferma  = JOptionPane.showConfirmDialog(null, "Sei sicuro di volere eliminare questa filiale: " + codice + "?", "Eliminazione", JOptionPane.YES_NO_OPTION);

                if(conferma != JOptionPane.YES_OPTION){
                    return;
                }
                try {
                    controller.eliminaFiliale(codice);
                    JOptionPane.showMessageDialog(null, "Filiale eliminata con successo! ");
                    aggiornaListaButton.doClick();
                } catch (FilialeNonTrovataException eccezione){
                    JOptionPane.showMessageDialog(null, eccezione.getMessage(), "Errore la filiale non esiste", JOptionPane.ERROR_MESSAGE);
                } catch(Exception eccezione){
                    JOptionPane.showMessageDialog(null, eccezione.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
