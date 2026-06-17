package implementazionePostgresDAO;

import dao.RiparazioneDAO;
import model.Riparazione;
import model.Veicolo;
import database.ConnessioneDatabase;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

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
    public void save(Riparazione riparazione) {
        String sql = "INSERT INTO Riparazione (targaVeicolo, descrizioneProblema," +
                "costoStimato, costoFinale, dataRiparazione)" + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, riparazione.getTargaVeicolo());
            statement.setString(2, riparazione.getDescrizioneProblema());
            statement.setFloat(3, riparazione.getCostoStimato());
            statement.setFloat(4, riparazione.getCostoFinale());
            statement.setDate(5, java.sql.Date.valueOf(String.valueOf(riparazione.getDataRiparazione())));


            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Impossibile salvare la riparazione.", ex);
        }
    }

    @Override
    public boolean update(Riparazione riparazione) {
        String sql = "UPDATE Riparazione SET costoFinale=?, descrizioneProblema=?" +
                "WHERE targaVeicolo = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setFloat(1, riparazione.getCostoFinale());
            statement.setString(2, riparazione.getDescrizioneProblema());
            statement.setString(3, riparazione.getTargaVeicolo());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Impossibile aggiornare la riparazione.", ex);
        }
        return true;
    }


    @Override
    public List<Riparazione> findAll() {
        List<Riparazione> lista = new ArrayList();
        String sql = "SELECT * FROM Riparazione";

        try (Statement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery(sql)) {
            while (result.next()) {
                lista.add(estraiRiparazione(result));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Impossibile generare la lista delle riparazioni.", ex);
        }
        return lista;
    }

    private Riparazione estraiRiparazione(ResultSet result) throws SQLException {
        return new Riparazione(result.getFloat("costoStimato"), result.getString("descrizioneProblema"), result.getFloat("costoFinale"), result.getDate("dataRiparazione"), result.getString("targaVeicolo"));
    }
}
