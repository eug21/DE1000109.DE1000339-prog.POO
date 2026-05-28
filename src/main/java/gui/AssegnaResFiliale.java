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
        setTitle("Assegna a una filiale");
        setContentPane(assegna);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        assegnaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codiceFiliale = testoFilialeTextField.getText().trim();
                String idRes = testoIdTextField.getText().trim();

                try{
                    controller.assegnaResponsabileAFiliale(idRes,codiceFiliale);
                    JOptionPane.showMessageDialog(null, "Responsabile assegnato con successo", "Successo", JOptionPane.INFORMATION_MESSAGE);
                    testoFilialeTextField.setText("");
                    testoIdTextField.setText("");
                } catch (ResponsabileNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null, "Il responsabile non esiste", "Errore", JOptionPane.ERROR_MESSAGE);
                } catch (FilialeNonTrovataException eccezione){
                    JOptionPane.showMessageDialog(null, "La filiale non esiste", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
