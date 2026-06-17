package dao;

import model.Contratto;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface ContrattoDAO {
    void save (Contratto contratto);
    void chiudi (Contratto contratto);
    List <Contratto> trovaPerCliente (String numeroPatente);
    List <Contratto> trovaPerFiliale (String codiceFiliale);
    List <Contratto> trovaPerPeriodo (LocalDate dataInizio, LocalDate dataFine);
}
