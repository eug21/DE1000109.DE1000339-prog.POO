package controller;


//import per i metodi di Cliente
import dao.*;
import exception.*;
import implementazionePostgresDAO.*;
import model.Cliente;
import model.TipoPatente;

//import per i metodi di Veicolo
import model.Veicolo;
import model.StatoVeicolo;
import java.math.BigDecimal;
import java.util.List;


//import per metodi di filiale
import model.Filiale;

//import per i metodi di contratto
import model.Contratto;

import java.time.LocalDate;

//import per i metodi di responsabile
import model.Responsabile;

//import per i metodi di meccanico
import model.Meccanico;

//import per i metodi di riparazione
import model.Riparazione;
import java.util.Date;

public class Controller {

    private final ClienteDAO clienteDAO;
    private final FilialeDAO filialeDAO;
    private final VeicoloDAO veicoloDAO;
    private final MeccanicoDAO meccanicoDAO;
    private final ResponsabileDAO responsabileDAO;
    private final RiparazioneDAO riparazioneDAO;
    private final ContrattoDAO contrattoDAO;
    public Controller (){
        this.filialeDAO = new FilialeDAOImpl();
        this.clienteDAO = new ClienteDAOImpl();
        this.veicoloDAO = new VeicoloDAOImpl();
       this.meccanicoDAO = new MeccanicoDAOImpl();
        this.responsabileDAO = new ResponsabileDAOImpl();
        this.riparazioneDAO = new RiparazioneDAOImpl();
        this.contrattoDAO = new ContrattoDAOImpl();

     }


    //registrazione cliente
    public Cliente registraCliente(String nome, String cognome, String cf, TipoPatente tipo, String numPatente) throws Exception {
        Cliente cliente = new Cliente(nome, cognome, cf, tipo, numPatente);

        if (!cliente.verificaRegistrazione()) {
            throw new Exception("Dati cliente non validi.");

        }
        clienteDAO.save(cliente);
        return cliente;

    }

    //ricerco i clienti per numero di patente che uso come PK

    public Cliente ricercaPerPatente(String numPatente) throws ClienteNonTrovatoException {
        if (numPatente == null || numPatente.isBlank()) {
            throw new ClienteNonTrovatoException("Numero patente non valido.");
        }
        Cliente cliente = clienteDAO.trovaPerPatente(numPatente);

        if (cliente == null) {
            throw new ClienteNonTrovatoException("Il cliente non esiste " + numPatente);

        }
        return cliente;

    }

    //elimina un cliente dal db
    public boolean eliminaCliente(String numPatente) throws ClienteNonTrovatoException{
        Cliente cliente = ricercaPerPatente(numPatente);
        //da aggiungere verifica di contratti attivi

        return clienteDAO.delete(numPatente);
    }

    //trova tutti i clienti
    public List<Cliente> getTuttiClienti(){
        return clienteDAO.findAll();
    }


    // da ora in poi ci sono i metodi relativi ai veicoli


    public Veicolo aggiungiVeicolo(Veicolo veicolo) throws VeicoloNonTrovatoException{
        if (!veicolo.verificaDatiVeicolo()) {
            throw new VeicoloNonTrovatoException("Il veicolo non e' registrato correttamente.");
        }

        veicoloDAO.save(veicolo);
        return veicolo;
    }

    public Veicolo cercaTarga(String targa) throws VeicoloNonTrovatoException{
        if (targa == null || targa.isBlank()) {
            throw new VeicoloNonTrovatoException("La targa non e' valida.");
        }
        return veicoloDAO.trovaPerTarga(targa);
    }

    //aggiorno a db lo stato di un veicolo mediante l'uso di setStatoVeicolo dal model
    public boolean aggiornaStatoVeicolo(String targa, StatoVeicolo stato) throws VeicoloNonTrovatoException{
        Veicolo veicolo = cercaTarga(targa);
        if (veicolo == null) {
            throw new VeicoloNonTrovatoException("Veicolo non trovato " + targa);

        }
        veicolo.setStatoVeicolo(stato);
        veicoloDAO.update(veicolo);
        return true;
    }

    public boolean eliminaVeicolo(String targa) throws VeicoloNonTrovatoException, VeicoloNonDisponibileException {
        Veicolo veicolo = cercaTarga(targa);

        if (veicolo == null) {
            throw new VeicoloNonTrovatoException("Il veicolo non esiste " + targa);
        }
        if (!veicolo.verificaDisponibile()) {
            throw new VeicoloNonDisponibileException("Il veicolo non e' disponibile " + targa);
        }
        veicoloDAO.delete(targa);
        return true;
    }

    public List<Veicolo> getVeicoliDisponibili() throws Exception {
        return veicoloDAO.cercaStato(StatoVeicolo.Disponibile);
    }

    public List<Veicolo> getVeicoliManutenzione() throws Exception {
        return veicoloDAO.cercaStato(StatoVeicolo.Manutenzione);
    }

    public List<Veicolo> getVeicoliNoleggiati() throws Exception {
        return veicoloDAO.cercaStato(StatoVeicolo.Noleggiato);
    }

    //seguono i metodi della classe filiale


    //aggiungere una filiale a db
    public Filiale aggiungiFiliale(String codiceFiliale, String via, String citta, String cap, String numeroTelefono) throws DatiFilialeNonValidaException{
        Filiale filiale = new Filiale(codiceFiliale, via, citta, cap, numeroTelefono);
        if (!filiale.verificaDatiFiliale()) {
            throw new DatiFilialeNonValidaException("I dati inseriti non sono validi. ");
        }
        filialeDAO.save(filiale);
        return filiale;
    }

    //ricerca di una filiale mediante il suo codice univoco nel db
    public Filiale cercaConIdFiliale(String codiceFiliale) throws FilialeNonTrovataException{
        if (codiceFiliale == null || codiceFiliale.isBlank()) {
            throw new FilialeNonTrovataException("La filiale non esiste.");
        }
        return filialeDAO.trovaPerCodice(codiceFiliale);
    }

    //eliminazione di una filiale dal db
    public boolean eliminaFiliale(String codiceFiliale) throws FilialeNonTrovataException{
        Filiale filiale = cercaConIdFiliale(codiceFiliale);
        if (filiale == null) {
            throw new FilialeNonTrovataException("La filiale non esiste. ");
        }
        filialeDAO.delete(codiceFiliale);
        return true;
    }

    //modifica dei dati di una filiale
    public boolean modificaDatiFiliale(String nuovoCodice, String nuovaVia, String nuovoCap, String nuovaCitta, String nuovoNumTelefono, String codiceFiliale) throws DatiFilialeNonValidaException, FilialeNonTrovataException{
        Filiale filiale = cercaConIdFiliale(codiceFiliale);
        if (filiale == null) {
            throw new FilialeNonTrovataException("La filiale non esiste. ");
        }

        Filiale filialeTemp = new Filiale(nuovoCodice, nuovaVia, nuovaCitta, nuovoCap, nuovoNumTelefono);

        if (!filialeTemp.verificaDatiFiliale()) {
            throw new DatiFilialeNonValidaException("I dati inseriti non sono validi. ");
        }
        filiale.setCodiceFiliale(nuovoCodice);
        filiale.setCap(nuovoCap);
        filiale.setCitta(nuovaCitta);
        filiale.setVia(nuovaVia);
        filiale.setNumeroTelefono(nuovoNumTelefono);

        filialeDAO.update(filiale);
        return true;
    }

    //lista di tutte le filiali presenti a db
    public List<Filiale> getFiliali()  {
        return filialeDAO.getAll();
    }

    //seguono tutti i metodi che consentono di manipoalare i contratti


    //aggiunta di un contratto
    public Contratto aggiungiContratto(String idFilialeRitiro, String idFilialeConsegna, LocalDate dataInizio, LocalDate dataFine, BigDecimal prezzo, Cliente cliente, Veicolo veicolo) throws VeicoloNonDisponibileException, ClienteNonTrovatoException, DateContrattoNonValideException, PatenteNonValidaException {
        if (!veicolo.verificaDisponibile()) {
            throw new VeicoloNonDisponibileException("Il veicolo non e' disponibile. ");
        }
        if (!cliente.verificaPatente()) {
            throw new PatenteNonValidaException("Il cliente non ha una patente abilitata alla conduzione di tale veicolo. ");
        }

        Contratto contratto = new Contratto(idFilialeRitiro, idFilialeConsegna, veicolo.getTarga(), dataInizio, dataFine, BigDecimal.ZERO);
        if(!contratto.verificaDate()){
            throw new DateContrattoNonValideException("Le date del contratto non sono valide. ");
        }
        BigDecimal prezzoFinale = veicolo.getTariffaDie().multiply(BigDecimal.valueOf(contratto.getDurataNoleggio()));
        contratto.setPrezzo(prezzoFinale);
        veicolo.setStatoVeicolo(StatoVeicolo.Noleggiato);
        contrattoDAO.save(contratto);
        veicoloDAO.update(veicolo);
        return contratto;
    }

    //metodo di chiusura di un contratto
    public boolean chiudiContratto(Contratto contratto) throws VeicoloNonTrovatoException, ContrattoNonValidoException {
        if(contratto == null ){
            throw new ContrattoNonValidoException("Il contratto non e' valido. ");
        }
        Veicolo veicolo = cercaTarga(contratto.getTargaVeicolo());
        veicolo.setStatoVeicolo(StatoVeicolo.Disponibile);
        veicoloDAO.update(veicolo);
        contrattoDAO.chiudi(contratto);
        return true;
    }

    //metodo che mostra tutti i contratti relativi a un cliente
    public List<Contratto> getContrattiCliente(Cliente cliente) throws ClienteNonTrovatoException {
        if (cliente == null) {
            throw new ClienteNonTrovatoException("Il cliente non e' stato trovato. ");
        }
        return contrattoDAO.trovaPerCliente(cliente.getNumeroPatente());
    }

    //lista dei contratti attivi della filiale
    public List<Contratto> getContrattiFiliale(Filiale filiale) throws FilialeNonTrovataException {
        if (filiale == null) {
            throw new FilialeNonTrovataException("La filiale non esiste. ");
        }
        return contrattoDAO.trovaPerFiliale(filiale.getCodiceFiliale());
    }

    //calcolo del prezzo di un contratto in anteprima, prima della conferma e della successiva creazione di esso
    public BigDecimal calcolaCostoNoleggio(Veicolo veicolo, LocalDate dataInizio, LocalDate dataFine) throws DateContrattoNonValideException{
        Contratto contrattoTemp = new Contratto(null , null, null,dataInizio, dataFine, BigDecimal.ZERO);
        if(!contrattoTemp.verificaDate()){
            throw new DateContrattoNonValideException("Le date inserite non sono valide. ");
        }

        return veicolo.getTariffaDie().multiply(BigDecimal.valueOf(contrattoTemp.getDurataNoleggio()));
    }

    //lista dei contratti filtrata per periodo di date
    public List <Contratto> contrattiPerPeriodo (LocalDate dataInizio, LocalDate dataFine) throws DateContrattoNonValideException {
        Contratto temp = new Contratto(null, null, null, dataInizio, dataFine, BigDecimal.ZERO);
        if(!temp.verificaDate()){
            throw new DateContrattoNonValideException("Le date del contratto non sono valide. ");
        }
        return contrattoDAO.trovaPerPeriodo(dataInizio, dataFine);
    }

    //seguono i metodi della classe responsabile


    //aggiunge un responsabile
    public Responsabile aggiungiResponsabile(String idResponsabile, String nome, String cognome, String mail) throws DatiResponsabileNonValidiException , Exception{
    if(idResponsabile.isBlank() || nome.isBlank()||cognome.isBlank()||mail.isBlank()|| idResponsabile == null || nome == null || cognome == null || mail == null){
        throw new DatiResponsabileNonValidiException("I dati del responsabile non sono validi");
    }
    Responsabile responsabile = new Responsabile(idResponsabile, nome, cognome, mail);

    if (!responsabile.isDisponibile()) {
            throw new Exception("Dati responsabile non validi");
        }

        responsabileDAO.save(responsabile);
        return responsabile;
    }

    //ricerca responsabile per id
    public Responsabile cercaResponsabile(String idResponsabile) throws ResponsabileNonTrovatoException {
        if (idResponsabile == null || idResponsabile.isBlank()) {
            throw new ResponsabileNonTrovatoException("ID responsabile non valido.");
        }
        return responsabileDAO.trovaPerID(idResponsabile);
    }

    //elimina un responsabile
    public boolean eliminaResponsabile(String idResponsabile) throws ResponsabileNonTrovatoException {
        Responsabile responsabile = cercaResponsabile(idResponsabile);
        if (responsabile == null) {
            throw new ResponsabileNonTrovatoException("Il responsabile non esiste" + idResponsabile);
        }
      responsabileDAO.delete(idResponsabile);
        return true;
    }

    //lista di tutti i responsabili
    public List<Responsabile> getTuttiResponsabili()  {
       return responsabileDAO.findAll();
    }

    //assegna un responsabile a una filiale
    public boolean assegnaResponsabileAFiliale(String idResponsabile, String codiceFiliale) throws ResponsabileNonTrovatoException, FilialeNonTrovataException {

        Responsabile responsabile = cercaResponsabile(idResponsabile);
        if (responsabile == null) {
            throw new ResponsabileNonTrovatoException("Il responsabile non esiste" + idResponsabile);
        }
        Filiale filiale = cercaConIdFiliale(codiceFiliale);
        if (filiale == null) {
            throw new FilialeNonTrovataException("La filiale non esiste" + codiceFiliale);
        }
        responsabile.setDisponibile(false);
       responsabileDAO.assegnaFiliale(idResponsabile, codiceFiliale);
        responsabileDAO.update(responsabile);
        return true;
    }

    //rimuove un responsabile da una filiale
    public boolean rimuoviResponsabileDaFiliale(String idResponsabile, String codiceFiliale) throws ResponsabileNonTrovatoException, FilialeNonTrovataException {

        Responsabile responsabile = cercaResponsabile(idResponsabile);
        if (responsabile == null) {
            throw new ResponsabileNonTrovatoException("Il responsabile non esiste" + idResponsabile);
        }
        Filiale filiale = cercaConIdFiliale(codiceFiliale);
        if (filiale == null) {
            throw new FilialeNonTrovataException("La filiale non esiste" + codiceFiliale);
        }

        responsabile.setDisponibile(true);
       responsabileDAO.rimuoviDaFiliale(idResponsabile);
       responsabileDAO.update(responsabile);
        return true;
    }

    //metodi  per meccanico


    public Meccanico aggiungiMeccanico(String idMeccanico, String nome, String cognome) throws DatiMeccanicoNonValidiException {
        if(idMeccanico.isBlank() || nome.isBlank()||cognome.isBlank()|| idMeccanico== null || nome == null || cognome == null){
            throw new DatiMeccanicoNonValidiException("I dati del meccanico non sono validi");
        }
        Meccanico meccanico = new Meccanico(idMeccanico, nome, cognome);
        meccanicoDAO.save(meccanico);
        return meccanico;
    }

    public Meccanico cercaMeccanico(String idMeccanico) throws MeccanicoNonTrovatoException{
        if(idMeccanico.isBlank()||idMeccanico == null){
            throw new MeccanicoNonTrovatoException("Il meccanico non esiste");
        }
       return meccanicoDAO.trovaPerID(idMeccanico);

    }

    public boolean eliminaMeccanico(String idMeccanico)throws MeccanicoNonTrovatoException{
        if(idMeccanico.isBlank()||idMeccanico == null){
            throw new MeccanicoNonTrovatoException("Il meccanico non esiste");
        }
        Meccanico meccanico = cercaMeccanico(idMeccanico);
       meccanicoDAO.delete(idMeccanico);
        return true;
    }

    public boolean cambiaStatoMeccanico(String idMeccanico,boolean stato) throws MeccanicoNonTrovatoException{
        if(idMeccanico.isBlank()||idMeccanico == null){
            throw new MeccanicoNonTrovatoException("Il meccanico non esiste");
        }
        Meccanico meccanico = cercaMeccanico(idMeccanico);

        meccanico.setDisponibile(stato);
        return true;
    }

    public List <Meccanico> listaMeccanici(){
      return meccanicoDAO.findAll();

    }

    //seguono i metodi della classe riparazioni e meccanico


    //chiude la riparazione e aggiorna lo stato del veicolo
    public boolean chiudiRiparazioneVeicolo( String targaVeicolo, float costoFinale) throws RiparazioneNonTrovateException, DatiRiparazioneNonValidiException {

        if (targaVeicolo == null || targaVeicolo.isBlank() || costoFinale < 0) {
            throw new DatiRiparazioneNonValidiException("I dati non sono validi");
        }
       Riparazione riparazione = cercaRiparazionePerTarga(targaVeicolo);
        riparazione.setCostoFinale(costoFinale);
        Veicolo veicolo = cercaTarga(targaVeicolo);
        if(veicolo  != null){
            veicolo.setStatoVeicolo(StatoVeicolo.Disponibile);
            veicoloDAO.update(veicolo);
        }
      riparazioneDAO.update(riparazione);
        return true;
    }

    //aggiunge una riparazione controllando la disponbilità del meccanico
    public Riparazione aggiungiRiparazione(String descrizioneProblema, float costoStimato, Date dataRiparazione, float costoFinale, String targaVeicolo) throws DatiRiparazioneNonValidiException {

        if(descrizioneProblema == null || targaVeicolo == null || dataRiparazione == null || descrizioneProblema.isBlank() || targaVeicolo.isBlank() || costoStimato < 0 || costoFinale < 0){
            throw new DatiRiparazioneNonValidiException("La riparazione non e' valida");
        }
        Riparazione riparazione = new Riparazione(costoStimato, descrizioneProblema,costoFinale, dataRiparazione,targaVeicolo);
        Veicolo veicolo = cercaTarga(targaVeicolo);
        veicolo.setStatoVeicolo(StatoVeicolo.Manutenzione);
        veicoloDAO.update(veicolo);
        riparazioneDAO.save(riparazione);

        return riparazione;
    }

    public Riparazione cercaRiparazionePerTarga(String targaVeicolo) throws DatiRiparazioneNonValidiException, RiparazioneNonTrovateException{
        if (targaVeicolo == null || targaVeicolo.isBlank()) {
            throw new DatiRiparazioneNonValidiException("La targa non è valida.");
        }
        Riparazione riparazione = cercaRiparazionePerTarga(targaVeicolo);

        if (riparazione == null) {
            throw new RiparazioneNonTrovateException("Riparazione non trovata");
        }
        return riparazione;
    }

    //lista di tutte le riparazioni
    public List<Riparazione> getTutteRiparazioni(){
      return riparazioneDAO.findAll();

    }

}




