package dao;

import model.Riparazione;
import java.sql.SQLException;
import java.util.List;

public interface RiparazioneDAO {
    void save(Riparazione riparazione);
    boolean update(Riparazione riparazione);
    List<Riparazione> findAll();
}
