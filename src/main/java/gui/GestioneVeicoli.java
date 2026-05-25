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

            }
        });


        listaVeicoliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        cercaVeicoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
