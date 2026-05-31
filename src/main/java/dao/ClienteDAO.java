package dao;

import model.Cliente;
import java.sql.SQLException;
import java.util.List;

public interface ClienteDAO {
    void save(Cliente cliente) throws SQLException;
    Cliente trovaPerPatente (String numeroPatente) throws SQLException;
    boolean delete(String numeroPatente) throws SQLException;
    List <Cliente> findAll() throws SQLException;
}
