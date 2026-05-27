package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneRiparazione extends JFrame{
    private JPanel gestioneRiparazione;
    private JButton aggiungiButton;
    private JButton cercaButton;
    private JButton listaButton;

    private Controller controller = new Controller();

    public GestioneRiparazione(){
        setTitle("Scegli una opzione");
        setContentPane(gestioneRiparazione);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        aggiungiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AggiungiRiparazione frame = new AggiungiRiparazione();
                frame.setVisible(true);
            }
        });
        listaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaRiparazioni frame = new ListaRiparazioni();
                frame.setVisible(true);
            }
        });
        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CercaRiparazione frame = new CercaRiparazione();
                frame.setVisible(true);
            }
        });
    }
}
