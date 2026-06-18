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
                String idMec = idTextField.getText().trim().toUpperCase();
                String nome = nomeTextField.getText().trim();
                String cognome  = cognomeTextField.getText().trim();

                if(idMec.isEmpty() || nome.isEmpty() || cognome.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Compila i campi", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!idMec.matches("^[A-Z0-9]+$")) {
                    JOptionPane.showMessageDialog(null, "L'ID Meccanico deve contenere solo lettere e numeri.", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try{
                    controller.aggiungiMeccanico(idMec, nome, cognome);
                    idTextField.setText("");
                    nomeTextField.setText("");
                    cognomeTextField.setText("");
                    JOptionPane.showMessageDialog(null, "Meccanico aggiunto con successo", "Successo", JOptionPane.INFORMATION_MESSAGE);
                } catch (DatiMeccanicoNonValidiException eccezione){
                    JOptionPane.showMessageDialog(null, "Dati meccanico non valid", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    //trigger sql
                    String messaggioErrore = ex.getMessage();
                    if(ex.getCause() != null){
                        messaggioErrore = ex.getCause().getMessage();
                    }
                    JOptionPane.showMessageDialog(null, "Errore durante il salvataggio", messaggioErrore, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
