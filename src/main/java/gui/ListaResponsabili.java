package gui;

import controller.Controller;
import exception.ClienteNonTrovatoException;
import exception.ResponsabileNonTrovatoException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaResponsabili extends JFrame {
    private JPanel listaResponsabili;
    private JButton aggiornaListaButton;
    private JButton eliminaSelezionatoButton;
    private JTable table1;

    private Controller controller = new Controller();

    public ListaResponsabili(){
        setTitle("Lista responsabili");
        setContentPane(listaResponsabili);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        aggiornaListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] colonne = {"Id Responsabile", "Nome", "Cognome"};
                Object[][] righe = {};

                table1.setModel( new DefaultTableModel(righe, colonne));
            }
        });
        eliminaSelezionatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int riga = table1.getSelectedRow();
                if(riga == -1){
                    JOptionPane.showMessageDialog(null, "Devi selezionare un responsabile", "Attenzione",  JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String idRes = (String) table1.getValueAt(riga,0);
                int conferma = JOptionPane.showConfirmDialog(null, "Sei sicuro di volere eliminare il responsabile " + idRes +  "?", "Conferma", JOptionPane.YES_NO_OPTION);
                if(conferma != JOptionPane.YES_OPTION){
                    return;
                }
                try{
                    controller.eliminaResponsabile(idRes);
                    JOptionPane.showMessageDialog(null, "Responsabile eliminato con successo", "Responsabile eliminato", JOptionPane.INFORMATION_MESSAGE);
                    aggiornaListaButton.doClick();

                } catch (ResponsabileNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null, "Il responsabile non e' stato trovato", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                } catch(Exception eccezione){
                    JOptionPane.showMessageDialog(null, "Errore", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
