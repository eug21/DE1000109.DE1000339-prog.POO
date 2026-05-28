package gui;

import controller.Controller;
import exception.DatiResponsabileNonValidiException;
import model.Responsabile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AggiungiResponsabile extends JFrame{
    private JPanel aggiungiResponsabile;
    private JButton aggiungiButton;
    private JTextField testoidTextField;
    private JTextField testoNomeTextField;
    private JTextField testoCognomeTextField;
    private JTextField testoMailTextField;

    private Controller controller = new Controller();

    public AggiungiResponsabile(){
        setTitle("Inserisci i campi");
        setContentPane(aggiungiResponsabile);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        aggiungiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idResponsabile = testoidTextField.getText().trim();
                String nome = testoNomeTextField.getText().trim();
                String cognome = testoCognomeTextField.getText().trim();
                String mail = testoMailTextField.getText().trim();

                try{
                    controller.aggiungiResponsabile(idResponsabile,nome, cognome, mail);
                    testoidTextField.setText("");
                    testoNomeTextField.setText("");
                    testoCognomeTextField.setText("");
                    testoMailTextField.setText("");

                }
                catch(DatiResponsabileNonValidiException eccezione){
                    JOptionPane.showMessageDialog(null, "Dati inseriti non validi", "Errore", JOptionPane.ERROR_MESSAGE);
                } catch(Exception eccezione){
                    JOptionPane.showMessageDialog(null, "Errore", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
