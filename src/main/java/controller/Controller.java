package controller;


//import per i metodi di Cliente
import exception.*;
import model.Cliente;
import model.TipoPatente;
import dao.ClienteDAO;

//import per i metodi di Veicolo
import model.Veicolo;
import dao.VeicoloDAO;
import model.StatoVeicolo;
import java.math.BigDecimal;
import java.util.List;


//import dei metodi di fliale
import model.Filiale;
import dao.FilialeDAO;

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

    public Veicolo cercaTarga (String targa) throws VeicoloNonTrovatoException{
        if(targa == null || targa.isBlank()){
            throw new VeicoloNonTrovatoException("La targa non e' valida.");
        }
       // return veicoloDAO.trovaPerTarga(targa);
        return null; //da togliere
    }

    //aggiorno a db lo stato di un veicolo mediante l'uso di setStatoVeicolo dal model
    public boolean aggiornaStatoVeicolo (String targa, StatoVeicolo stato) throws VeicoloNonTrovatoException{
        Veicolo veicolo = cercaTarga(targa);
        if(veicolo == null){
            throw new VeicoloNonTrovatoException("Veicolo non trovato " + targa);

        }
        veicolo.setStatoVeicolo(stato);
        // da fare veicoloDAO.update(veicolo);
        return true;
    }

    public boolean eliminaVeicolo ( String targa) throws VeicoloNonTrovatoException, VeicoloNonDisponibileException {
        Veicolo veicolo = cercaTarga(targa);

        if (veicolo == null){
            throw new VeicoloNonTrovatoException("Il veicolo non esiste " + targa);
        }
        if(!veicolo.verificaDisponibile()){
            throw new VeicoloNonDisponibileException("Il veicolo non e' disponibile " + targa);
        }
        // da fare veicoloDAO.delete(veicolo);
        return true;
    }
    public List <Veicolo> getVeicoliDisponibili()throws Exception{
       // da fare veicoloDAO.cercaStato(StatoVeicolo.Dispoonibile);
        return null;
    }

    public List<Veicolo> getVeicoliManutenzione() throws  Exception{
        // da fare veicoloDAO.cercaStato(StatoVeicolo.Manutenzione);
        return null;
    }

    public List <Veicolo> getVeicoliNoleggiati() throws Exception{
        // da fare veicoloDAO.cercaStato(StatoVeicolo.Noleggiato);
        return null;
    }

    //seguono i metodi della classe filiale
   // private final FilialeDAO filialeDAO;
   // public Controller(){
    //    this.filialeDAO = new FilialeDAOImpl;
    //}

    //aggiungere una filiale a db
    public Filiale aggiungiFiliale(String codiceFiliale, String via, String citta, String cap, String numeroTelefono) throws DatiFilialeNonValidaException {
        Filiale filiale = new Filiale (codiceFiliale, via, citta, cap, numeroTelefono);
        if(!filiale.verificaDatiFiliale()){
            throw new DatiFilialeNonValidaException("I dati inseriti non sono validi. ");
        }
        // da fare filialeDAO.save(filiale);
        return filiale;
    }

    public Filiale cercaConIdFiliale(String codiceFiliale) throws FilialeNonTrovataException{
        if(codiceFiliale == null || codiceFiliale.isBlank() ){
            throw new FilialeNonTrovataException("La filiale non esiste.");
        }
        // da fare nel dao return filialeDAO.trovaPerCodice(codiceFiliale);
        return null; //da levare
    }

    public boolean eliminaFiliale(String codiceFiliale)throws FilialeNonTrovataException{
        Filiale filiale = cercaConIdFiliale(codiceFiliale);
        if(filiale == null){
            throw new FilialeNonTrovataException("La filiale non esiste. ");
        }
        // da fare nel dao filialeDAO.delete(filiale);
        return true;
    }



}
