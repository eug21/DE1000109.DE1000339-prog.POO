package gui;

import controller.Controller;
import exception.ClienteNonTrovatoException;
import exception.ContrattoNonValidoException;
import model.Contratto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class CercaPerDate extends JFrame{
    private JPanel cercaPerDate;
    private JButton aggiornaListaButton;
    private JButton eliminaContrattoButton;
    private JScrollPane scroll;
    private JTable tabContratti;
    private JTextField inizioTextField;
    private JTextField fineTextField;

    private Controller controller = new Controller();

    public CercaPerDate(){
        setTitle("Cerca contratti per date");
        setContentPane(cercaPerDate);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        aggiornaListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] colonne = { controller.contrattiPerPeriodo(LocalDate.parse(inizioTextField.getText().trim()), LocalDate.parse(fineTextField.getText().trim())).toString() + "Filiale Consegna"  + "Data Fine" + "Prezzo"};
                Object[][] righe = {};

                tabContratti.setModel(new DefaultTableModel(righe, colonne));
            }
        });


        eliminaContrattoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int riga = tabContratti.getSelectedRow();
                if(riga == -1){
                    JOptionPane.showMessageDialog(null, "Devi selezionare un contratto", "Attenzione",  JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int conferma = JOptionPane.showConfirmDialog(null, "Sei sicuro di volere eliminare il contratto ?", "Conferma", JOptionPane.YES_NO_OPTION);
                if(conferma != JOptionPane.YES_OPTION){
                    return;
                }
                int modelRow = tabContratti.convertRowIndexToModel(riga);
                //Contratto contratto = tabContratti.get(modelRow);
                Contratto contratto = null;
                try{
                    controller.chiudiContratto(contratto);
                    JOptionPane.showMessageDialog(null, "Contratto eliminato con successo", "Contratto eliminato", JOptionPane.INFORMATION_MESSAGE);
                    aggiornaListaButton.doClick();

                } catch (ContrattoNonValidoException eccezione){
                    JOptionPane.showMessageDialog(null, "Il contratto non e' stato trovato", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                } catch(Exception eccezione){
                    JOptionPane.showMessageDialog(null, "Errore", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
