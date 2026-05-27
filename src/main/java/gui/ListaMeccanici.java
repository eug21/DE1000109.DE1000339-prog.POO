package gui;

import controller.Controller;

import javax.swing.*;

public class ListaMeccanici extends JFrame{
    private JButton aggiornaListaButton;
    private JPanel lista;
    private JScrollPane scroll;
    private JTable tab;
    private JButton eliminaSelezionatoButton;

    private Controller controller = new Controller();

    public ListaMeccanici(){
        setTitle("Ecco i meccanici");
        setContentPane(lista);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
