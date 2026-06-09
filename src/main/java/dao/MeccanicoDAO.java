
 package dao;

import model.Meccanico;
import java.sql.SQLException;
import java.util.List;

public interface MeccanicoDAO{
 void save(Meccanico meccanico) throws SQLException;
 Meccanico trovaPerID(String idMeccanico) throws SQLException;
 boolean delete(String idMeccanico) throws SQLException;
 list<Meccanico> findAll() throws SQLException;
}