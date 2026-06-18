package gui;

import javax.swing.*;
import controller.Controller;
import exception.ClienteNonTrovatoException;
import exception.DatiClienteNonValidi;
import model.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CercaCliente extends  JFrame{
    private JPanel cercaCliente;
    private JTextField numeroPatenteTesto;
    private JTextField nomeTesto;
    private JTextField cognomeTesto;
    private JTextField fiscaleTesto;
    private JTextField tipoTesto;
    private JButton cerca;

    private Controller controller = new Controller();
    public CercaCliente(){
        setTitle("Cerca Cliente");
        setContentPane(cercaCliente);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        nomeTesto.setVisible(false);
        cognomeTesto.setVisible(false);
        fiscaleTesto.setVisible(false);
        tipoTesto.setVisible(false);
        cerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroPatente = numeroPatenteTesto.getText().trim().toUpperCase();
                if(!numeroPatente.matches("^[A-Z0-9]{9,10}$")){
                    JOptionPane.showMessageDialog(null, "Formato patente non valido, rispettare quello Europeo.","Attenzione", JOptionPane.WARNING_MESSAGE);

                    nomeTesto.setVisible(false);
                    cognomeTesto.setVisible(false);
                    fiscaleTesto.setVisible(false);
                    tipoTesto.setVisible(false);
                    return;
                }
                if(numeroPatente.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Compila i campi", "Attenzione", JOptionPane.WARNING_MESSAGE);

                    nomeTesto.setVisible(false);
                    cognomeTesto.setVisible(false);
                    fiscaleTesto.setVisible(false);
                    tipoTesto.setVisible(false);
                    return;
                }
                try{
                    Cliente cliente = controller.ricercaPerPatente(numeroPatente);
                    nomeTesto.setText(cliente.getNome());
                    cognomeTesto.setText(cliente.getCognome());
                    fiscaleTesto.setText(cliente.getCodiceFiscale());
                    tipoTesto.setText(cliente.getTipoPatente().toString());
                    JOptionPane.showMessageDialog(null, "Cliente trovato con successo", "Successo", JOptionPane.INFORMATION_MESSAGE);


                    nomeTesto.setVisible(true);
                    cognomeTesto.setVisible(true);
                    fiscaleTesto.setVisible(true);
                    tipoTesto.setVisible(true);

                } catch(ClienteNonTrovatoException eccezione) {
                    JOptionPane.showMessageDialog(null, "Il cliente non esiste", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);

                    nomeTesto.setVisible(false);
                    cognomeTesto.setVisible(false);
                    fiscaleTesto.setVisible(false);
                    tipoTesto.setVisible(false);


                }

                catch (Exception eccezione){
                    // prendo l' errore dal trigger postgres
                    String messaggioErrore = eccezione.getMessage();
                    if(eccezione.getCause() != null){
                        messaggioErrore = eccezione.getCause().getMessage();
                    }
                    JOptionPane.showMessageDialog(null,messaggioErrore,  "Errore in fase di inserimento", JOptionPane.ERROR_MESSAGE);
                    nomeTesto.setVisible(false);
                    cognomeTesto.setVisible(false);
                    fiscaleTesto.setVisible(false);
                    tipoTesto.setVisible(false);

                }
            }
        });
    }
}
