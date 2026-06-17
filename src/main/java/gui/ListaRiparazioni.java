package gui;

import controller.Controller;
import exception.MeccanicoNonTrovatoException;
import exception.RiparazioneNonTrovateException;
import model.Filiale;
import model.Riparazione;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListaRiparazioni extends JFrame {
    private JPanel lista;
    private JButton aggiornaListaButton;
    private JButton chiudiSelezionataButton;
    private JScrollPane scrool;
    private JTable table1;

    private Controller controller = new Controller();

    public ListaRiparazioni(){
        setTitle("Lista riparazioni");
        setContentPane(lista);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        aggiornaListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] colonne = {"Problema", "Costo stimato", "Costo finale", "Targa", "Data riparazione"};
                DefaultTableModel modello = new DefaultTableModel(null, colonne);
                List<Riparazione> lista = controller.getTutteRiparazioni();
                if(lista != null){
                    for (Riparazione r: lista){
                        modello.addRow(new Object[]{ r.getDescrizioneProblema(),
                                r.getCostoStimato(),
                                r.getCostoFinale(),
                                r.getTargaVeicolo(),
                                r.getDataRiparazione()});
                    }
                }
                table1.setModel(modello);
            }
        });
        chiudiSelezionataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int riga = table1.getSelectedRow();
                if(riga == -1){
                    JOptionPane.showMessageDialog(null, "Seleziona una riparazione da chiudere", "Attenzione" ,JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String targa  = (String) table1.getValueAt(riga, 4);
                Float prezzo = (Float)  table1.getValueAt(riga, 3);
                int conferma  = JOptionPane.showConfirmDialog(null, "Sei sicuro di volere chiudere questa riparazione su questo veicolo: " + targa + "?", "Eliminazione", JOptionPane.YES_NO_OPTION);

                if(conferma != JOptionPane.YES_OPTION){
                    return;
                }
                try {
                    controller.chiudiRiparazioneVeicolo(targa,prezzo);
                    JOptionPane.showMessageDialog(null, "Riparazione eliminata con successo! ");
                    aggiornaListaButton.doClick();
                } catch (RiparazioneNonTrovateException eccezione){
                    JOptionPane.showMessageDialog(null, "La riparazione non esiste", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
