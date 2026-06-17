
 package dao;

import model.Meccanico;
import java.sql.SQLException;
import java.util.List;

public interface MeccanicoDAO{
 void save(Meccanico meccanico);
 Meccanico trovaPerID(String idMeccanico);
 boolean delete(String idMeccanico) ;
 List<Meccanico> findAll() ;
}