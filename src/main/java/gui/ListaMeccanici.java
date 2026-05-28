package gui;

import controller.Controller;
import exception.MeccanicoNonTrovatoException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaMeccanici extends JFrame{
    private JButton aggiornaListaButton;
    private JPanel lista;
    private JScrollPane scroll;
    private JTable tab;
    private JButton eliminaSelezionatoButton;

    private Controller controller = new Controller();

    public ListaMeccanici(){
        setTitle("Ecco i meccanici");
        setContentPane(lista);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        aggiornaListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] colonne = {"ID Meccanico", "Nome", "Cognome"};
                Object [][] righe = {};

                tab.setModel(new DefaultTableModel(righe, colonne));
            }
        });
        eliminaSelezionatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int riga = tab.getSelectedRow();
                if(riga == -1){
                    JOptionPane.showMessageDialog(null, "Seleziona un meccanico da eliminare", "Attenzione" ,JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String idMec  = (String) tab.getValueAt(riga, 0);
                int conferma  = JOptionPane.showConfirmDialog(null, "Sei sicuro di volere eliminare questo meccanico: " + idMec + "?", "Eliminazione", JOptionPane.YES_NO_OPTION);

                if(conferma != JOptionPane.YES_OPTION){
                    return;
                }
                try {
                    controller.eliminaMeccanico(idMec);
                    JOptionPane.showMessageDialog(null, "Filiale eliminata con successo! ");
                    aggiornaListaButton.doClick();
                } catch (MeccanicoNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null, "Il meccanico non esiste", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
