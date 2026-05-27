package gui;

import controller.Controller;
import exception.ClienteNonTrovatoException;
import exception.DateContrattoNonValideException;
import exception.VeicoloNonDisponibileException;
import exception.VeicoloNonTrovatoException;
import model.Cliente;
import model.Veicolo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;


public class AggiungiContratto extends JFrame {
    private JPanel aggiungiContratto;
    private JTextField testoPatenteTextField;
    private JTextField testoTargaTextField;
    private JTextField ritiroTextField;
    private JTextField consegnaTextField;
    private JTextField inizioTextField;
    private JTextField fineTextField;
    private JButton calcolaPrezzoButton;
    private JButton confermaButton;
    private JLabel stima;
    private JButton cercaClienteButton;
    private JButton cercaVeicoloButton;
    private JLabel cliente;
    private JLabel veicolo;

    private Controller controller = new Controller();

    private Cliente clienteTrovato = null;
    private Veicolo veicoloTrovato = null;

    public AggiungiContratto(){

        ritiroTextField.setVisible(false);
        consegnaTextField.setVisible(false);
        inizioTextField.setVisible(false);
        fineTextField.setVisible(false);
        calcolaPrezzoButton.setVisible(false);
        stima.setVisible(false);
        confermaButton.setVisible(false);

        cercaClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patente = (String) testoPatenteTextField.getText().trim();
                try{
                    clienteTrovato = controller.ricercaPerPatente(patente);
                    cliente.setText(clienteTrovato.getNome() + " " + clienteTrovato.getCognome());

                } catch (ClienteNonTrovatoException eccezione) {
                    JOptionPane.showMessageDialog(null, "Il cliente non esiste", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                    clienteTrovato = null;
                }
            }
        });
        cercaVeicoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String targa = (String) testoTargaTextField.getText().trim();
                try{
                    veicoloTrovato = controller.cercaTarga(targa);
                    if(!veicoloTrovato.verificaDisponibile()){
                        JOptionPane.showMessageDialog(null, "Il veicolo trovato non e' disponibile", "Errore", JOptionPane.ERROR_MESSAGE);
                        veicoloTrovato = null;
                        return;
                    }
                    veicolo.setText(veicoloTrovato.getMarca() + " " + veicoloTrovato.getModello());
                } catch (VeicoloNonTrovatoException eccezione){
                    JOptionPane.showMessageDialog(null, "Il veicolo non esiste", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                    veicoloTrovato = null;
                }
            }
        });
        calcolaPrezzoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    LocalDate dataInizio = LocalDate.parse(inizioTextField.getText().trim());
                    LocalDate dataFine = LocalDate.parse(fineTextField.getText().trim());
                    BigDecimal prezzo = controller.calcolaCostoNoleggio(veicoloTrovato, dataInizio, dataFine);

                    stima.setText("Prezzo stimato: € " + prezzo.toString());
                    stima.setVisible(true);
                    confermaButton.setVisible(true);

                } catch (DateContrattoNonValideException eccezione){
                    JOptionPane.showMessageDialog(null, "Date non valide", eccezione.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String filialeRitiro = ritiroTextField.getText().trim();
                    String filialeConsegna = consegnaTextField.getText().trim();
                    LocalDate inizio = LocalDate.parse(inizioTextField.getText().trim());
                    LocalDate fine = LocalDate.parse(fineTextField.getText().trim());

                    controller.aggiungiContratto(filialeRitiro, filialeConsegna, inizio, fine, BigDecimal.ZERO, clienteTrovato, veicoloTrovato);
                    JOptionPane.showMessageDialog(null, "Contratto creato con successo", "Successo", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception eccezione){
                    JOptionPane.showMessageDialog(null, "Errore", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }
}
