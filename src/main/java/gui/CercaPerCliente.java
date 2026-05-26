package gui;

import controller.Controller;
import exception.ClienteNonTrovatoException;
import model.Cliente;
import model.Contratto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CercaPerCliente extends JFrame {
    private JPanel cercaPerCliente;
    private JTextField numeroPatenteTextField;
    private JButton cercaButton;
    private JScrollPane scroll;
    private JTable tabContratti;


    public CercaPerCliente() {
        Controller controller = new Controller();

        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patente = numeroPatenteTextField.getText().trim();

                if(patente.isBlank()){
                    JOptionPane.showMessageDialog(null, "Si prega di inserire un numero di patente", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try{
                    Cliente cliente = controller.ricercaPerPatente(patente);
                    List < Contratto> contrattiDelCliente = controller.getContrattiCliente(cliente);
                    if(contrattiDelCliente == null || contrattiDelCliente.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Il cliente non ha contratti", "Errore", JOptionPane.ERROR_MESSAGE);
                    }

                    String [] colonne = {"Filiale Ritiro", "Filiale Consegna", "Targa","Marca", "Modello", "Porte", "Cilindrata", "Carico", "Prezzo"};
                    for(int i = 0; i<contrattiDelCliente.size(); i++){
                        // da implementare la stampa dei dati tramite recupero dal db
                    }
                } catch (ClienteNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null,"Il cliente non esite", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
