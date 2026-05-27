package gui;

import controller.Controller;

import javax.swing.*;

public class CercaMeccanico  extends JFrame{
    private JTextField idTextField;
    private JTextField nomeTextField;
    private JTextField cognomeTextField;
    private JButton cercaButton;
    private JPanel cerca;
    private JButton aggiornaStatoButton;

    private Controller controller = new Controller();

    public CercaMeccanico(){
        setTitle("Cerca un meccanico");
        setContentPane(cerca);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
