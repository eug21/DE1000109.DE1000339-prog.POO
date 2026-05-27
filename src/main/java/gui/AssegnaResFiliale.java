package gui;

import controller.Controller;

import javax.swing.*;

public class AssegnaResFiliale  extends JFrame {
    private JTextField testoFilialeTextField;
    private JTextField testoIdTextField;
    private JButton assegnaButton;
    private JPanel assegna;


    private Controller controller = new Controller();
    public AssegnaResFiliale(){
        setTitle("Assegna a una filiale");
        setContentPane(assegna);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
