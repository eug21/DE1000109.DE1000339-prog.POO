package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SceltaDipendente extends JFrame{
    private JPanel sceltaDipendente;
    private JButton responsabileButton;
    private JButton meccanicoButton;

    private Controller controller = new Controller();


    public SceltaDipendente() {

        setTitle("Seleziona un dipendente");
        setContentPane(sceltaDipendente);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        responsabileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestioneResponsabili frame = new GestioneResponsabili();
                frame.setVisible(true);

            }
        });
        meccanicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestioneMeccanico frame = new GestioneMeccanico();
                frame.setVisible(true);

            }
        });
    }
}
