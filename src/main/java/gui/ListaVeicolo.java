package gui;

import controller.Controller;
import exception.VeicoloNonDisponibileException;
import exception.VeicoloNonTrovatoException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaVeicolo extends JFrame {
    private JPanel listaVeicolo;
    private JButton noleggiatiButton;
    private JButton tuttiButton;
    private JButton disponibiliButton;
    private JButton manutenzioneButton;
    private JTable tabellaVeicoli;
    private JButton eliminaSelezionatoButton;

    private Controller controller = new Controller();

    public ListaVeicolo(){
        Object[][] righe = {};
        String[] colonne = {"Targa", "Marca", "Modello", "Tariffa", "Stato"};

        tuttiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabellaVeicoli.setModel(new DefaultTableModel(righe, colonne));
            }
        });
        disponibiliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // da fare controller.getVeicoliNoleggiati();
                Object[][] righe = {};
                tabellaVeicoli.setModel(new DefaultTableModel(righe, colonne));
            }
        });
        manutenzioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // da farae controller.getVeicoliManutenzione();
                Object[][] righe  = {};
                tabellaVeicoli.setModel(new DefaultTableModel(righe, colonne));
            }
        });
        noleggiatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // da fare controller.getVeicoliNoleggiati();
                Object[][] righe = {};
                tabellaVeicoli.setModel(new DefaultTableModel(righe, colonne));
            }
        });
        eliminaSelezionatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int riga = tabellaVeicoli.getSelectedRow();
                if(riga == -1){
                    JOptionPane.showMessageDialog(null, "Veicolo non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String targa  = (String) tabellaVeicoli.getValueAt(riga, 0);

                int conferma = JOptionPane.showConfirmDialog(null, "Sei sicuro di volere eliminare questo veicolo? ", "Conferma", JOptionPane.YES_NO_OPTION);
                if(conferma != JOptionPane.YES_OPTION){
                    return;
                }
                try{
                    controller.eliminaVeicolo(targa);
                    JOptionPane.showMessageDialog(null, "Veicolo eliminato! ", "Successo", JOptionPane.INFORMATION_MESSAGE);
                    tuttiButton.doClick();
                } catch (VeicoloNonTrovatoException eccezione) {
                    JOptionPane.showMessageDialog(null, "Veicolo non trovato", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);

                } catch (VeicoloNonDisponibileException eccezione){
                    JOptionPane.showMessageDialog(null, "Veicolo non disponobile", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
