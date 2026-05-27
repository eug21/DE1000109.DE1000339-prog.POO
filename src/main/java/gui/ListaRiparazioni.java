package gui;

import controller.Controller;

import javax.swing.*;

public class ListaRiparazioni extends JFrame {
    private JPanel lista;
    private JButton aggiornaListaButton;
    private JButton chiudiSelezionataButton;
    private JScrollPane scrool;
    private JTable table1;

    private Controller controller = new Controller();

    public ListaRiparazioni(){
        setTitle("Lista riparazioni");
        setContentPane(lista);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
