package gui;

import controller.Controller;

import javax.naming.ldap.Control;
import javax.swing.*;

public class AggiungiRiparazione extends JFrame {
    private JPanel aggiungi;
    private JTextField targaTextField;
    private JTextField problemaTextField;
    private JTextField stimaTextField;
    private JTextField prezzpTextField;
    private JTextField dataTextField;
    private JButton aggiungiButton;

    private Controller controller = new Controller();

    public AggiungiRiparazione(){
        setTitle("Aggiungi una riparazione");
        setContentPane(aggiungi);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

}
