package gui;

import controller.Controller;
import exception.DatiFilialeNonValidaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class GestioneFiliali extends JFrame {
    private JButton aggiungiFilialeButton;
    private JPanel gestioneFiliali;
    private JButton listaFilialiButton;
    private JButton cercaFilialeButton;

    private Controller controller;

    public GestioneFiliali(Controller controllerHome) {
        this.controller = controllerHome;
        setTitle("Gestione Filiali");
        setContentPane(gestioneFiliali);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        aggiungiFilialeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            AggiungiFiliale frame = new AggiungiFiliale(controller);
            frame.setVisible(true);

            }
        });

        listaFilialiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaFiliali frame = new ListaFiliali(controller);
                frame.setVisible(true);
            }
        });
        cercaFilialeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cercaFiliale frame = new cercaFiliale(controller);
                frame.setVisible(true);
            }
        });
    }

}


