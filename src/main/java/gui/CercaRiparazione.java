package gui;

import controller.Controller;
import exception.DatiRiparazioneNonValidiException;
import exception.RiparazioneNonTrovateException;
import model.Riparazione;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

public class CercaRiparazione extends JFrame{
    private JPanel cerca;
    private JTextField dataTextField;
    private JTextField finaleTextField;
    private JTextField stimaTextField;
    private JTextField problemaTextField;
    private JTextField targaTextField;
    private JButton cercaButton;

    private Controller controller = new Controller();

    public CercaRiparazione(){
        setTitle("Cerca una riparazione");
        setContentPane(cerca);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String targa = targaTextField.getText().trim();

                try{
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    Riparazione riparazione = controller.cercaRiparazionePerTarga(targa);
                    problemaTextField.setText(riparazione.getDescrizioneProblema());
                    stimaTextField.setText(String.valueOf(riparazione.getCostoStimato()));
                    finaleTextField.setText(String.valueOf(riparazione.getCostoFinale()));
                    dataTextField.setText(String.valueOf(riparazione.getDataRiparazione()));

                } catch(RiparazioneNonTrovateException eccezione){
                    JOptionPane.showMessageDialog(null, "La riparazione non esiste", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
