package controller;


//import per i metodi di Cliente
import dao.ContrattoDAO;
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


//import per metodi di filiale
import model.Filiale;
import dao.FilialeDAO;

//import per i metodi di contratto
import model.Contratto;
import dao.ContrattoDAO;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    //ricerca di una filiale mediante il suo codice univoco nel db
    public Filiale cercaConIdFiliale(String codiceFiliale) throws FilialeNonTrovataException{
        if(codiceFiliale == null || codiceFiliale.isBlank() ){
            throw new FilialeNonTrovataException("La filiale non esiste.");
        }
        // da fare nel dao return filialeDAO.trovaPerCodice(codiceFiliale);
        return null; //da levare
    }

    //eliminazione di una filiale dal db
    public boolean eliminaFiliale(String codiceFiliale)throws FilialeNonTrovataException{
        Filiale filiale = cercaConIdFiliale(codiceFiliale);
        if(filiale == null){
            throw new FilialeNonTrovataException("La filiale non esiste. ");
        }
        // da fare nel dao filialeDAO.delete(filiale);
        return true;
    }

    //modifica dei dati di una filiale
    public boolean modificaDatiFiliale(String nuovoCodice, String nuovaVia, String nuovoCap, String nuovaCitta, String nuovoNumTelefono, String codiceFiliale) throws DatiFilialeNonValidaException, FilialeNonTrovataException{
        Filiale filiale = cercaConIdFiliale(codiceFiliale);
        if (filiale == null){
            throw new FilialeNonTrovataException("La filiale non esiste. ");
        }

        Filiale filialeTemp = new Filiale(nuovoCodice, nuovaVia, nuovaCitta, nuovoCap, nuovoNumTelefono);

        if(!filialeTemp.verificaDatiFiliale()){
            throw new DatiFilialeNonValidaException("I dati inseriti non sono validi. ");
        }
        filiale.setCodiceFiliale(nuovoCodice);
        filiale.setCap(nuovoCap);
        filiale.setCitta(nuovaCitta);
        filiale.setVia(nuovaVia);
        filiale.setNumeroTelefono(nuovoNumTelefono);

       // da fare nel dao  filialeDAO.update(filiale);
        return true;
    }

    //lista di tutte le filiali presenti a db
    public List <Filiale> getFiliali (){
        //return filialeDAO.getAll();
        return null;
    }

    //seguono tutti i metodi che consentono di manipoalare i contratti
    //private final ContrattoDAO contrattoDAO;
   // private Controller(){
      //  this.contrattoDAO = new ContrattoDAOImpl;
    //}

    //aggiunta di un contratto
    public Contratto aggiungiContratto(String idFilialeRitiro, String idFilialeConsegna, LocalDate dataInizio, LocalDate dataFine, BigDecimal prezzo, Cliente cliente, Veicolo veicolo) throws VeicoloNonDisponibileException, ClienteNonTrovatoException, DateContrattoNonValideException{
        if(!veicolo.verificaDisponibile()){
            throw new VeicoloNonDisponibileException("Il veicolo non e' disponibile. ");
        }
        if(!cliente.verificaPatente()){
            throw new ClienteNonTrovatoException("Il cliente non ha una patente abilitata alla conduzione di tale veicolo. ");
        }

        Contratto contratto = new Contratto(idFilialeRitiro, idFilialeConsegna, dataInizio, dataFine, BigDecimal.ZERO);
        if(!contratto.verificaDate()){
            throw new DateContrattoNonValideException("Le date del contratto non sono valide. ");
        }
        BigDecimal prezzoFinale = veicolo.getTariffaDie().multiply(BigDecimal.valueOf(contratto.getDurataNoleggio()));
        contratto.setPrezzo(prezzoFinale);
        veicolo.setStatoVeicolo(StatoVeicolo.Noleggiato);
       // da fare contrattoDAO.save(contratto);
       //  da fare veicoloDAO.update(veicolo);
        return contratto;
    }
    //metodo di chiusura di un contratto
    public boolean chiudiContratto(Contratto contratto, Veicolo veicolo) throws VeicoloNonTrovatoException, ContrattoNonValidoException{
        if(contratto == null ){
            throw new ContrattoNonValidoException("Il contratto non e' valido. ");
        }
        veicolo.setStatoVeicolo(StatoVeicolo.Dispoonibile);
       // da fare veicoloDAO.update(veicolo);
        // da fare contrattoDAO.chiudi(contratto);
        return true;
    }

    //metodo che mostra tutti i contratti relativi a un cliente
    public List <Contratto> getContrattiCliente(Cliente cliente) throws ContrattoNonValidoException, ClienteNonTrovatoException{
        if (cliente == null){
            throw new ClienteNonTrovatoException("Il cliente non e' stato trovato. ");
        }
        // da fare return contrattoDAO.trovaPerCliente(cliente.getNumeroPatente());
        return null; // da rimuovere
    }

    //lista dei contratti attivi della filiale
    public List <Contratto> getContrattiFiliale (Filiale filiale) throws FilialeNonTrovataException{
        if(filiale == null){
            throw new FilialeNonTrovataException("La filiale non esiste. ");
        }
        // da fare return contrattoDAO.trovaPerFiliale(filiale.getCodiceFiliale());
        return null; //da levare
    }








}
