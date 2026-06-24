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
    private JButton modificaEmailButton;

    private Controller controller; 

    public CercaRes(Controller controllerHome){
        this.controller = controllerHome;
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
        mailTextField.setEditable(true);


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
                    nomeTextField.setVisible(true);
                    cognomeTextField.setVisible(true);
                    mailTextField.setVisible(true);


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
        modificaEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idResponsabile = idTextField.getText().trim().toUpperCase();
                String nuovaEmail = mailTextField.getText().trim();
            if(idResponsabile.isEmpty() || nuovaEmail.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Compila i campi", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            if (!idResponsabile.matches("^[A-Z0-9]+$")) {
                    JOptionPane.showMessageDialog(null, "L'ID Responsabile deve contenere solo lettere e numeri.", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            if (!nuovaEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                    JOptionPane.showMessageDialog(null, "Formato email non valido.", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            try{
                controller.modificaEmail(idResponsabile, nuovaEmail);
                JOptionPane.showMessageDialog(null, "Email modificata con successo.", "Successo", JOptionPane.INFORMATION_MESSAGE);
            } catch (ResponsabileNonTrovatoException exception){
                JOptionPane.showMessageDialog(null, "Impossibile trovare il responsabile", "Errore", JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception eccezione){
                // prendo l' errore dal trigger postgres
                String messaggioErrore = eccezione.getMessage();
                if(eccezione.getCause() != null){
                    messaggioErrore = eccezione.getCause().getMessage();
                }
                JOptionPane.showMessageDialog(null,messaggioErrore,  "Errore in fase di inserimento", JOptionPane.ERROR_MESSAGE);
                eccezione.printStackTrace();
            }

            }
        });
    }
}
