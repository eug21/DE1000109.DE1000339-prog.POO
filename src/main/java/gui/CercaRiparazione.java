package gui;

import controller.Controller;

import javax.swing.*;

public class CercaRiparazione extends JFrame{
    private JPanel cerca;
    private JTextField dataTextField;
    private JTextField finaleTextField;
    private JTextField stimaTextField;
    private JTextField problemaTextField;
    private JTextField targaTextField;
    private JButton cercaButton;

    private Controller controller = new Controller();

    public CercaRiparazione(){
        setTitle("Cerca una riparazione");
        setContentPane(cerca);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
