
package  dao;

import model.Responsabile;
import java.sql.SQLException;
import java.util.List;

public interface ResponsabileDAO{
    void save(Responsabile responsabile) throws SQLException;
    Responsabile trovaPerID(String idResponsabile) throws  SQLException;
    List<Responsabile> findALL() throws SQLException;

}