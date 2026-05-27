package gui;

import controller.Controller;

import javax.swing.*;

public class CercaRes extends JFrame {
    private JPanel cercaRes;
    private JTextField mailTextField;
    private JTextField idTextField;
    private JTextField nomeTextField;
    private JTextField cognomeTextField;
    private JButton cercaButton;

    private Controller controller = new Controller();

    public CercaRes(){
        setTitle("Cerca un responsabile");
        setContentPane(cercaRes);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
