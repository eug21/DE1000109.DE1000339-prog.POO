package gui;

import controller.Controller;
import exception.ClienteNonTrovatoException;
import model.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListaClienti extends JFrame {
    private JPanel listaClienti;
    private JButton aggiornaListaButton;
    private JButton eliminaClienteButton;
    private JTable tabellaClienti;

    private Controller controller;

    public ListaClienti(Controller controllerHome) {
        this.controller = controllerHome;
        setTitle("Lista dei clienti");
        setContentPane(listaClienti);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        aggiornaListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] colonne = {"Numero Patente", "Nome", "Cognome", "Codice Fiscale", "Tipo Patente"};
                DefaultTableModel modello = new DefaultTableModel(null, colonne);
                List<Cliente> lista = controller.getTuttiClienti();
                if(lista != null){
                    for (Cliente cliente: lista){
                        modello.addRow(new Object[]{ cliente.getNumeroPatente(),
                                cliente.getNome(),
                                cliente.getCognome(),
                                cliente.getCodiceFiscale(),
                                cliente.getTipoPatente()});
                    }
                }
                tabellaClienti.setModel(modello);
            }

        });

        eliminaClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int riga = tabellaClienti.getSelectedRow();
                if(riga == -1){
                    JOptionPane.showMessageDialog(null, "Devi selezionare un cliente", "Attenzione",  JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String numeroPatente = (String) tabellaClienti.getValueAt(riga,0);
                int conferma = JOptionPane.showConfirmDialog(null, "Sei sicuro di volere eliminare il cliente " + numeroPatente +  "?", "Conferma", JOptionPane.YES_NO_OPTION);
                if(conferma != JOptionPane.YES_OPTION){
                    return;
                }
                try{
                    controller.eliminaCliente(numeroPatente);
                    JOptionPane.showMessageDialog(null, "Cliente eliminato con successo", "Cliente eliminato", JOptionPane.INFORMATION_MESSAGE);
                    aggiornaListaButton.doClick();

                } catch (ClienteNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null, "Il cliente non e' stato trovato", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                } catch (Exception eccezione) {
                    JOptionPane.showMessageDialog(null, "ERRORE", "Errore di sistema", JOptionPane.ERROR_MESSAGE);
    
                }

            }
        });
        aggiornaListaButton.doClick();
    }
}
