package dao;
import model.Filiale;

import java.sql.SQLException;
import java.util.List;

public interface FilialeDAO {

    void save(Filiale filiale) throws SQLException;
    Filiale trovaPerCodice(String codiceFiliale) throws SQLException;
    void delete (String codicFiliale) throws SQLException;
    void update (Filiale filiale) throws SQLException;
    List <Filiale> getAll() throws SQLException;

}
