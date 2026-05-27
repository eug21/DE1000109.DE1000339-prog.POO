package gui;

import controller.Controller;

import javax.swing.*;

public class GestioneMeccanico extends JFrame{
    private JPanel gestioneMeccanico;
    private JButton aggiungiButton;
    private JButton cercaButton;
    private JButton aggiornaStatoButton;
    private JButton listaButton;

    private Controller controller = new Controller();

    public GestioneMeccanico(){

        setTitle("Scegli un'opzione");
        setContentPane(gestioneMeccanico);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
