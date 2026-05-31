package dao;

import model.Contratto;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface ContrattoDAO {
    void save (Contratto contratto) throws SQLException;
    void chiudi (Contratto contratto) throws SQLException;
    List <Contratto> trovaPerCliente (String numeroPatente) throws SQLException;
    List <Contratto> trovaPerFiliale (String codiceFiliale) throws SQLException;
    List <Contratto> trovaPerPeriodo (LocalDate dataInizio, LocalDate dataFine) throws SQLException;
}
