package gui;

import controller.Controller;

import javax.swing.*;

public class ListaResponsabili extends JFrame {
    private JPanel listaResponsabili;
    private JButton aggiornaListaButton;
    private JButton eliminaSelezionatoButton;
    private JTable table1;

    private Controller controller = new Controller();

    public ListaResponsabili(){
        setTitle("Lista responsabili");
        setContentPane(listaResponsabili);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
