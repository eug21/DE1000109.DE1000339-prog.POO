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
        nomeTesto.setVisible(false);
        cognomeTesto.setVisible(false);
        fiscaleTesto.setVisible(false);
        tipoTesto.setVisible(false);
        cerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroPatente = numeroPatenteTesto.getText().trim();
                try{
                    Cliente cliente = controller.ricercaPerPatente(numeroPatente);
                    nomeTesto.setText(cliente.getNome());
                    cognomeTesto.setText(cliente.getCognome());
                    fiscaleTesto.setText(cliente.getCodiceFiscale());
                    tipoTesto.setText(cliente.getTipoPatente().toString());

                    nomeTesto.setVisible(true);
                    cognomeTesto.setVisible(true);
                    fiscaleTesto.setVisible(true);
                    tipoTesto.setVisible(true);

                } catch(ClienteNonTrovatoException eccezione) {
                    JOptionPane.showMessageDialog(null, "Il cliente non esiste", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);



                }
            }
        });
    }
}
