package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JPanel Home;
    private JLabel titolo;
    private JButton GESTIONECLIENTIButton;
    private JButton GESTIONEDIPENDENTIButton;
    private JButton GESTIONEFILIALIButton;
    private JButton GESTIONEVEICOLIButton;
    private JButton GESTIONERIPARAZIONIButton;
    private JButton GESTIONECONTRATTIButton;

    public Home() {
        GESTIONECLIENTIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestioneClienti frame = new GestioneClienti();
                frame.setVisible(true);

            }
        });
        GESTIONEDIPENDENTIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SceltaDipendente frame = new SceltaDipendente();
                frame.setVisible(true);

            }
        });
        GESTIONEFILIALIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestioneFiliali frame = new GestioneFiliali();
                frame.setVisible(true);
            }
        });
        GESTIONEVEICOLIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestioneVeicoli frame = new GestioneVeicoli();
                frame.setVisible(true);
            }
        });
        GESTIONERIPARAZIONIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestioneRiparazione frame = new GestioneRiparazione();
                frame.setVisible(true);
            }
        });
        GESTIONECONTRATTIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestioneContratti frame = new GestioneContratti();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Home");
        frame.setContentPane(new Home().Home);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
