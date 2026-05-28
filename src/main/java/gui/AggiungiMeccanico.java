package gui;

import controller.Controller;
import exception.DatiMeccanicoNonValidiException;
import model.Meccanico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AggiungiMeccanico extends JFrame {
    private JPanel aggiungi;
    private JTextField idTextField;
    private JTextField nomeTextField;
    private JTextField cognomeTextField;
    private JButton aggiungiButton;

    private Controller controller = new Controller();

    public AggiungiMeccanico(){
        setTitle("Aggiungi un meccanico");
        setContentPane(aggiungi);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        aggiungiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idMec = idTextField.getText().trim();
                String nome = nomeTextField.getText().trim();
                String cognome  = cognomeTextField.getText().trim();

                try{
                    Meccanico meccanico = controller.aggiungiMeccanico(idMec, nome, cognome);
                    idTextField.setText("");
                    nomeTextField.setText("");
                    cognomeTextField.setText("");
                    JOptionPane.showMessageDialog(null, "Meccanico aggiunto con successo", "Successo", JOptionPane.INFORMATION_MESSAGE);
                } catch (DatiMeccanicoNonValidiException eccezione){
                    JOptionPane.showMessageDialog(null, "Dati meccanico non valid", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
