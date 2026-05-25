package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JPanel Home;
    private JLabel titolo;
    private JButton GESTIONECLIENTIButton;
    private JButton GESTIONEDIPENDENTIButton;
    private JButton GESTIONEFILIALIButton;
    private JButton GESTIONEVEICOLIButton;

    public Home() {
        GESTIONECLIENTIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        GESTIONEDIPENDENTIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        GESTIONEFILIALIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestioneFiliali frame = new GestioneFiliali();
                frame.setVisible(true);
            }
        });
        GESTIONEVEICOLIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
