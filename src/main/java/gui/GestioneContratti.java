package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneContratti {
    private JPanel gestioneContratti;
    private JButton nuovoContrattoButton;
    private JButton listaContrattiButton;
    private JButton cercaPerClienteButton;
    private JButton cercaPerFilialeButton;

    private Controller controller = new Controller();

    public GestioneContratti(){

        nuovoContrattoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        listaContrattiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cercaPerClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cercaPerFilialeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
