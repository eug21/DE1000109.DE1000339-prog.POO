package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneContratti {
    private JPanel gestioneContratti;
    private JButton nuovoContrattoButton;
    private JButton cercaDate;
    private JButton cercaPerClienteButton;
    private JButton cercaPerFilialeButton;

    private Controller controller = new Controller();

    public GestioneContratti(){

        nuovoContrattoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AggiungiContratto frame = new AggiungiContratto();
                frame.setVisible(true);

            }
        });
        cercaDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CercaPerDate frame = new CercaPerDate();
                frame.setVisible(true);

            }
        });
        cercaPerClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CercaPerCliente frame = new CercaPerCliente();
                frame.setVisible(true);

            }
        });
        cercaPerFilialeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
