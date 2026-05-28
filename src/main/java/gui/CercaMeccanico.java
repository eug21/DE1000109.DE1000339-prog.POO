package gui;

import controller.Controller;
import exception.MeccanicoNonTrovatoException;
import model.Meccanico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String idMec =  idTextField.getText().trim();

               try{
                   Meccanico meccanico = controller.cercaMeccanico(idMec);
                   nomeTextField.setText(meccanico.getNome());
                   cognomeTextField.setText(meccanico.getCognome());

               } catch (MeccanicoNonTrovatoException eccezione){
                   JOptionPane.showMessageDialog(null, "Il meccanico non esiste", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }


            }

        });
        aggiornaStatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Meccanico meccanico = null;
                try{
                    meccanico = controller.cercaMeccanico(idTextField.getText().trim());

                } catch(MeccanicoNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null, "Il meccanico non esiste", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);

                }
                Boolean stato = meccanico.isDisponibile();
                if(!stato){
                    JOptionPane.showMessageDialog(null, "Il meccanico non e' disponibile", "Errore", JOptionPane.INFORMATION_MESSAGE);
                }

                try{
                    controller.cambiaStatoMeccanico(meccanico.getIdMeccanico(), stato);
                    JOptionPane.showMessageDialog(null,"Stato cambiato con successo", "Successo", JOptionPane.INFORMATION_MESSAGE);

                }catch (MeccanicoNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null, "Il meccanico non e' disponibile", "Errore", JOptionPane.INFORMATION_MESSAGE);

                }

            }
        });
    }
}
