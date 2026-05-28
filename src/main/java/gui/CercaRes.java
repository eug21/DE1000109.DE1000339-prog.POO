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


        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idRes = idTextField.getText().trim();
                try{
                    Responsabile responsabile = controller.cercaResponsabile(idRes);
                    nomeTextField.setText(responsabile.getNome());
                    cognomeTextField.setText(responsabile.getCognome());

                } catch (ResponsabileNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null,"Il responsabile non esiste", "Errore", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
