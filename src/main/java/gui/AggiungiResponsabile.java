package gui;

import controller.Controller;

import javax.swing.*;

public class AggiungiResponsabile extends JFrame{
    private JPanel aggiungiResponsabile;
    private JButton aggiungiButton;
    private JTextField testoIdTextField;
    private JTextField testoNomeTextField;
    private JTextField testoCognomeTextField;
    private JTextField testoMailTextField;

    private Controller controller = new Controller();

    public AggiungiResponsabile(){
        setTitle("Inserisci i campi");
        setContentPane(aggiungiResponsabile);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
