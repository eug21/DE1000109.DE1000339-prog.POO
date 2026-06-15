package dao;

import model.Riparazione;
import java.sql.SQLException;
import java.util.List;

public interface RiparazioneDAO {
    void save(Riparazione riparazione) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean update(Riparazione riparazione) throws  SQLException;
    List<Riparazione> finAll() throws SQLException;
}
