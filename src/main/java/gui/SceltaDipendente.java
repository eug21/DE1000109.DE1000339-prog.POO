package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SceltaDipendente extends JFrame{
    private JPanel sceltaDipendente;
    private JButton responsabileButton;
    private JButton meccanicoButton;

    private Controller controller; 


    public SceltaDipendente(Controller controllerHome) {
        this.controller = controllerHome;

        setTitle("Seleziona un dipendente");
        setContentPane(sceltaDipendente);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        responsabileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestioneResponsabili frame = new GestioneResponsabili(controller);
                frame.setVisible(true);

            }
        });
        meccanicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestioneMeccanico frame = new GestioneMeccanico(controller);
                frame.setVisible(true);

            }
        });
    }
}
