package gui;

import javax.swing.*;
import controller.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneVeicoli extends JFrame {
    private JPanel gestioneVeicoli;
    private JButton aggiungiVeicoloButton;
    private JButton cercaVeicoloButton;
    private JButton listaVeicoliButton;

    private Controller controller = new Controller();

    public GestioneVeicoli(){

        aggiungiVeicoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AggiuntaVeicolo frame = new AggiuntaVeicolo();
                frame.setVisible(true);

            }
        });


        listaVeicoliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestioneVeicoli frame = new GestioneVeicoli();
                frame.setVisible(true);

            }
        });


        cercaVeicoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CercaVeicolo frame = new CercaVeicolo();
                frame.setVisible(true);

            }
        });
    }

}
