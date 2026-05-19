package controller;


//import per i metodi di Cliente
import exception.VeicoloNonTrovatoException;
import model.Cliente;
import model.TipoPatente;
import dao.ClienteDAO;
import exception.ClienteNonTrovatoException;

//import per i metodi di Veicolo
import model.Veicolo;
import dao.VeicoloDAO;
import model.StatoVeicolo;
import java.math.BigDecimal;

public class Controller {

    //private final ClienteDAO clienteDAO;
    //public Controller (){
       // this.clienteDAO = newClienteDAOImpl;
   // }


    //registrazione cliente
    public Cliente registraCliente(String nome, String cognome, String cf, TipoPatente tipo, String numPatente) throws Exception{
        Cliente cliente = new Cliente (nome, cognome, cf, tipo, numPatente);

        if(!cliente.verificaRegistrazione()){
            throw new Exception("Dati cliente non validi.");

        }
        //da fare nel dao clienteDAO.save(cliente);
        return cliente;

    }

    //ricerco i clienti per numero di patente che uso come PK

    public Cliente ricercaPerPatente(String numPatente) throws ClienteNonTrovatoException {
        if(numPatente == null || numPatente.isBlank()){
            throw new ClienteNonTrovatoException("Numero patente non valido.");
        }

       Cliente cliente = clienteDAO.trovaPerPatente(numPatente);  //da fare

        if (cliente == null){
            throw new ClienteNonTrovatoException("Il cliente non esiste "  + numPatente);

        }
        return cliente;

    }

   //elimina un cliente dal db
    public boolean eliminaCliente(String numPatente) throws ClienteNonTrovatoException{
       // Cliente cliente = ricercaPerPatente(numPatente);
        //da aggiungere verifica di contratti attivi

        // return clienteDAO.delete(numPatente); //da fare nel dao
    }


    // da ora in poi ci sono i metodi relativi ai veicoli

    //metodo per aggiunta di un veicolo a db

   // private final VeicoloDAO veicoloDAO;
    //public Controller (){
     //   this.veicoloDAO =
   // }

    public Veicolo aggiungiVeicolo(Veicolo veicolo) throws VeicoloNonTrovatoException {
        if (!veicolo.verificaDatiVeicolo()){
            throw new VeicoloNonTrovatoException("Il veicolo non e' registrato correttamente.");
        }

        // da fare veicoloDAO.save(veicolo);
        return veicolo;
    }
}
