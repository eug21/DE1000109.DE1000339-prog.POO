package gui;

import controller.Controller;
import exception.FilialeNonTrovataException;
import exception.ResponsabileNonTrovatoException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssegnaResFiliale  extends JFrame {
    private JTextField testoFilialeTextField;
    private JTextField testoIdTextField;
    private JButton assegnaButton;
    private JPanel assegna;


    private Controller controller = new Controller();
    public AssegnaResFiliale(){
        setTitle("Assegna un responsabile a una filiale");
        setContentPane(assegna);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        assegnaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codiceFiliale = testoFilialeTextField.getText().trim().toUpperCase();
                if (!codiceFiliale.matches("^[A-Z0-9]+$")) {
                    JOptionPane.showMessageDialog(null, "Il codice filiale deve contenere solo lettere e numeri.", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String idRes = testoIdTextField.getText().trim().toUpperCase();
                if (!idRes.matches("^[A-Z0-9]+$")) {
                    JOptionPane.showMessageDialog(null, "L'ID Responsabile deve contenere solo lettere e numeri.", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(codiceFiliale.isEmpty() || idRes.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Compila i campi", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try{
                    controller.assegnaResponsabileAFiliale(idRes,codiceFiliale);
                    JOptionPane.showMessageDialog(null, "Responsabile assegnato con successo", "Successo", JOptionPane.INFORMATION_MESSAGE);
                    testoFilialeTextField.setText("");
                    testoIdTextField.setText("");
                } catch (ResponsabileNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null, "Il responsabile non esiste", "Errore", JOptionPane.ERROR_MESSAGE);
                } catch (FilialeNonTrovataException eccezione){
                    JOptionPane.showMessageDialog(null, "La filiale non esiste", "Errore", JOptionPane.ERROR_MESSAGE);
                }catch (Exception eccezione){
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
