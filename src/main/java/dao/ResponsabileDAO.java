
package  dao;

import model.Responsabile;
import java.sql.SQLException;
import java.util.List;

public interface ResponsabileDAO{
    void save(Responsabile responsabile);
    Responsabile trovaPerID(String idResponsabile);
    boolean delete(String idResponsabile) ;
    List<Responsabile> findAll();
    boolean update(Responsabile responsabile);
    boolean assegnaFiliale(String idResponsabile, String codiceFiliale);
    boolean rimuoviDaFiliale(String idResponsabile);
    boolean modificaEmail(String id, String email);
    String ottieniFiliale(String idResponsabile);
}