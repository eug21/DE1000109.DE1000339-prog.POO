package gui;

import controller.Controller;
import exception.ResponsabileNonTrovatoException;
import model.Responsabile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CercaRes extends JFrame {
    private JPanel cercaRes;
    private JTextField mailTextField;
    private JTextField idTextField;
    private JTextField nomeTextField;
    private JTextField cognomeTextField;
    private JButton cercaButton;

    private Controller controller = new Controller();

    public CercaRes(){
        setTitle("Cerca un responsabile");
        setContentPane(cercaRes);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        nomeTextField.setVisible(false);
        cognomeTextField.setVisible(false);
        mailTextField.setVisible(false);
        nomeTextField.setEditable(false);
        cognomeTextField.setEditable(false);
        mailTextField.setEditable(false);


        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idRes = idTextField.getText().trim().toUpperCase();
                if(idRes.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Compila i campi", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!idRes.matches("^[A-Z0-9]+$")) {
                    JOptionPane.showMessageDialog(null, "L'ID Responsabile deve contenere solo lettere e numeri.", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try{
                    Responsabile responsabile = controller.cercaResponsabile(idRes);
                    nomeTextField.setText(responsabile.getNome());
                    cognomeTextField.setText(responsabile.getCognome());
                    mailTextField.setText(responsabile.getMail());
                    nomeTextField.setVisible(false);
                    cognomeTextField.setVisible(false);
                    mailTextField.setVisible(false);


                } catch (ResponsabileNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null,"Il responsabile non esiste", "Errore", JOptionPane.ERROR_MESSAGE);
                    idTextField.setText("");
                }catch (Exception eccezione){
                    // prendo l' errore dal trigger postgres
                    String messaggioErrore = eccezione.getMessage();
                    if(eccezione.getCause() != null){
                        messaggioErrore = eccezione.getCause().getMessage();
                    }
                    JOptionPane.showMessageDialog(null,messaggioErrore,  "Errore in fase di inserimento", JOptionPane.ERROR_MESSAGE);
                    idTextField.setText("");

                }

            }
        });
    }
}
