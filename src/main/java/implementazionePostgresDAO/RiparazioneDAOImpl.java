package implementazionePostgresDAO;

import dao.RiparazioneDAO;
import model.Riparazione;
import model.Meccanico;
import model.Veicolo;
import database.ConnessioneDatabase;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;

public class RiparazioneDAOImpl implements RiparazioneDAO {

    private Connection connection;

    public RiparazioneDAOImpl() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void save(Riparazione riparazione) throws SQLException {
        String sql = "INSERT INTO Riparazione (targaVeicolo, descrizioneProblema," +
                "costoStimato, costoFinale, dataRiparazione)" + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, riparazione.getVeicolo().getTarga());
            statement.setString(2, riparazione.getMeccanico().getIdMeccanico());
            statement.setString(3, new java.sql.Date(riparazione.getDataRiparazione().getTime()));
            statement.setString(4, riparazione.getCostoStimato());
            statement.setString(5, riparazione.getCostoStimato());
            statement.setString(6, riparazione.getDescrizioneProblema());
            statement.executeUpdate();
        }
    }

    @Override
    public boolean update(Riparazione riparazione) throws SQLException{
        String sql = "UPDATE Riparazione SET costoFinale=?, descrizioneProblema=?" +
                "WHERE targaVeicolo = ? AND idMeccanico =?";

        try (PreparedStatement statement = connection.preparedStatement(sql)) {
            statement.setFloat(1, riparazione.getCostoFinale());
            statement.setString(2, riparazione.getDescrizioneProblema());
            statement.setString(3, riparazione.getVeicolo().getTarga());
            statement.setString(4, riparazione.get.Meccanico().getIdMeccanico());
            statement.executeUpdate();

    }
    return true;
  }

    @Override
    public void delete (int id) throws SQLException{
        String sql="DELETE FROM Riparazione WHERE id=?";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        }
        return true;
    }

    @Override
    public List<Riparazione> findAll() throws SQLException {
        List<Riparazione> lista = new ArrayList();
        String sql ="SELECT * FROM Riparazione";

        try (Statement statement = connection.CreateStatement();
             ResultSet result =statement.excuteQuery(sql)){
            while (result.next()){
                lista.add(estraiRiparazione(result));
            }
        }
        return lista;
    }

    private Riparazione estraiRiparazione(ResultSet result) throws SQLException{
        return new Riparazione(
                result.getFloat("costoStimato"),
                result.getString("descrizioneProblema"),
                result.getFloat("costoFinale"),
                result.getDate"dataRiparazione"),
                result.getString("targaVeicolo"),
                null,
                null
        );
    }
