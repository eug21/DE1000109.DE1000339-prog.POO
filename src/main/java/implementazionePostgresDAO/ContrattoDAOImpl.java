package implementazionePostgresDAO;

import dao.ContrattoDAO;
import model.Contratto;

import java.sql.*;

import database.ConnessioneDatabase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContrattoDAOImpl implements ContrattoDAO {

    private Connection connection;

    public ContrattoDAOImpl(){
        try{
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void save(Contratto contratto) throws SQLException {
        String sql = "INSERT INTO Contratto (idFilialeRitiro, idFilialeConsegna, targaVeicolo, dataInizio, dataFine, prezzo)" + "VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, contratto.getIdFilialeRitiro());
            statement.setString(2, contratto.getIdFilialeConsegna());
            statement.setString(3, contratto.getTargaVeicolo());
            statement.setDate(4, Date.valueOf(contratto.getDataInizio()));
            statement.setDate(5, Date.valueOf(contratto.getDataFine()));
            statement.setBigDecimal(6, contratto.getPrezzo());
            statement.executeUpdate();
        }
    }

    @Override
    public void chiudi(Contratto contratto) throws SQLException {
        String sql = "DELETE FROM Contratto WHERE targaVeicolo = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, contratto.getTargaVeicolo());
            statement.executeUpdate();
        }

    }

    @Override
    public List<Contratto> trovaPerCliente(String numeroPatente) throws SQLException {
        String sql = "SELECT * FROM Contratto WHERE numeroPatente = ?";
        List<Contratto> lista = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,numeroPatente);
            try(ResultSet result = statement.executeQuery()){
                while (result.next()){
                    lista.add(estraiResulContratto(result));
                }
            }
        }
        return lista;
    }

    @Override
    public List<Contratto> trovaPerFiliale(String codiceFiliale) throws SQLException {
            String sql = "SELECT * FROM Contratto WHERE idFilialeRitiro = ? OR idFilialeConsegna = ?";
        List<Contratto> lista = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,codiceFiliale);
            statement.setString(2, codiceFiliale);
            try(ResultSet result = statement.executeQuery()){
                while (result.next()){
                    lista.add(estraiResulContratto(result));
                }
            }
        }
        return lista;
    }

    @Override
    public List<Contratto> trovaPerPeriodo(LocalDate dataInizio, LocalDate dataFine) throws SQLException {
        String sql = "SELECT * FROM Contratto WHERE dataInizio >= ? AND dataFine <= ?";
        List<Contratto> lista = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, String.valueOf(Date.valueOf(dataInizio)));
            statement.setString(2, String.valueOf(Date.valueOf(dataFine)));
            try(ResultSet result = statement.executeQuery()){
                while (result.next()){
                    lista.add(estraiResulContratto(result));
                }
            }
        }
        return lista;
    }

    private Contratto estraiResulContratto(ResultSet result) throws SQLException{
        return new Contratto(result.getString("idFilialeRitiro"), result.getString("idFilialeConsegna"), result.getString("targaVeicolo"), result.getDate("dataInizio").toLocalDate(), result.getDate("dataFine").toLocalDate(), result.getBigDecimal("prezzo") );
    }
}
