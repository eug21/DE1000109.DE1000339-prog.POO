package dao;

import model.Veicolo;
import model.StatoVeicolo;
import java.sql.SQLException;
import java.util.List;

public interface VeicoloDAO {

    void save(Veicolo veicolo) throws SQLException;
    Veicolo trovaPerTarga (String targa) throws  SQLException;
    void update (Veicolo veicolo) throws SQLException;
    void delete (String targa) throws SQLException;
    List <Veicolo> cercaStato (StatoVeicolo stato) throws SQLException;
}
