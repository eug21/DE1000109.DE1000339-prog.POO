package gui;

import controller.Controller;
import exception.ClienteNonTrovatoException;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CercaPerCliente extends JFrame {
    private JPanel cercaPerCliente;
    private JTextField numeroPatenteTextField;
    private JButton cercaButton;
    private JScrollPane scroll;
    private JTable tabContratti;

    private Controller controller;

    public CercaPerCliente(Controller controllerHome) {
        this.controller = controllerHome;
        setTitle("Ricerca contratti per cliente");
        setContentPane(cercaPerCliente);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patente = numeroPatenteTextField.getText().trim().toUpperCase();
                if(patente.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Compila i campi", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(!patente.matches("^[A-Z0-9]{9,10}$")){
                    JOptionPane.showMessageDialog(null, "Formato patente non valido, rispettare quello Europeo.","Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }


                try{
                    Cliente cliente = controller.ricercaPerPatente(patente);
                    List <Contratto> contrattiDelCliente = controller.getContrattiCliente(cliente);

                    if(contrattiDelCliente == null || contrattiDelCliente.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Il cliente non ha contratti", "Errore", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String [] colonne = {"Filiale Ritiro", "Filiale Consegna", "Targa","Marca", "Modello", "Porte", "Cilindrata", "Carico", "Prezzo"};
                    DefaultTableModel modello = new DefaultTableModel(null, colonne);
                        for (Contratto c: contrattiDelCliente) {
                            String targa = c.getTargaVeicolo();
                            String marca = null;
                            String modelloV = null;
                            String porte = null;
                            String carico = null;
                            String cilindrata = null;
                            try {
                                Veicolo veicolo = controller.cercaTarga(targa);
                                marca = veicolo.getMarca();
                                modelloV = veicolo.getModello();
                                if (veicolo instanceof Auto) {
                                    porte = String.valueOf(((Auto) veicolo).getNumeroPorte());
                                } else if (veicolo instanceof Moto) {
                                    cilindrata = String.valueOf(((Moto) veicolo).getCilindrata());
                                } else if (veicolo instanceof Furgone) {
                                    carico = String.valueOf(((Furgone) veicolo).getCapacitaCarico());
                                }

                            } catch (Exception exception) {
                                JOptionPane.showMessageDialog(null, "Impossibile recuperare il veicolo" + targa, "Attenzione", JOptionPane.WARNING_MESSAGE);
                            }

                            Object[] riga = {c.getIdFilialeRitiro(),
                                    c.getIdFilialeConsegna(),
                                    targa,
                                    marca,
                                    modelloV,
                                    porte,
                                    cilindrata,
                                    carico,
                                    cliente.getTipoPatente()};
                            modello.addRow(riga);
                        }

                    tabContratti.setModel(modello);
                } catch (ClienteNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null,"Il cliente non esite", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception eccezione){
                    // prendo l' errore dal trigger postgres
                    String messaggioErrore = eccezione.getMessage();
                    if(eccezione.getCause() != null){
                        messaggioErrore = eccezione.getCause().getMessage();
                    }
                    JOptionPane.showMessageDialog(null,messaggioErrore,  "Errore in fase di inserimento", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
