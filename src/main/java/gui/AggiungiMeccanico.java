package gui;

import controller.Controller;

import javax.swing.*;

public class AggiungiMeccanico extends JFrame {
    private JPanel aggiungi;
    private JTextField idTextField;
    private JTextField nomeTextField;
    private JTextField cognomeTextField;
    private JButton aggiungiButton;

    private Controller controller = new Controller();

    public AggiungiMeccanico(){
        setTitle("Aggiungi un meccanico");
        setContentPane(aggiungi);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
