package gui;

import controller.Controller;
import exception.ResponsabileNonTrovatoException;
import model.Responsabile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListaResponsabili extends JFrame {
    private JPanel listaResponsabili;
    private JButton aggiornaListaButton;
    private JButton eliminaSelezionatoButton;
    private JTable table1;

    private Controller controller; 

    public ListaResponsabili(Controller controllerHome){
        this.controller = controllerHome;
        setTitle("Lista responsabili");
        setContentPane(listaResponsabili);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        aggiornaListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] colonne = {"Id Responsabile", "Nome", "Cognome", "Mail"};
                DefaultTableModel modello = new DefaultTableModel(null, colonne);
                List<Responsabile> lista = ListaResponsabili.this.controller.getTuttiResponsabili();
                if(lista != null){
                    for (Responsabile r: lista){
                        modello.addRow(new Object[]{ r.getIdResponsabileID(),
                                r.getNome(),
                                r.getCognome(),
                                r.getMail()});
                    }
                }
                table1.setModel(modello);
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
                    ListaResponsabili.this.controller.eliminaResponsabile(idRes);
                    JOptionPane.showMessageDialog(null, "Responsabile eliminato con successo", "Responsabile eliminato", JOptionPane.INFORMATION_MESSAGE);
                    aggiornaListaButton.doClick();

                } catch (ResponsabileNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null, "Il responsabile non e' stato trovato", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }  catch (Exception eccezione){
                    // prendo l' errore dal trigger postgres
                    String messaggioErrore = eccezione.getMessage();
                    if(eccezione.getCause() != null){
                        messaggioErrore = eccezione.getCause().getMessage();
                    }
                    JOptionPane.showMessageDialog(null,messaggioErrore,  "Errore in fase di inserimento", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        aggiornaListaButton.doClick();
    }
}
