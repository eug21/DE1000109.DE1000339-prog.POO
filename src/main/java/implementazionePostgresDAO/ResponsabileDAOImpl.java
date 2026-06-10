package implementazionePostgresDAO;

import dao.ResponsabileDAO;
import model.Responsabile;
import database.ConnessioneDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ResponsabileDAOImpl implements ResponsabileDAO{

    private connection connection;

    public ReposnabileDAOImpl(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Ovveride
    public void save(Responsabile responsabile) throws SQLException {
        String sql ="INSERT INTO Responsabile (idResponsabile, nome, cognome, mail) VALUES (?,?,?,?)";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, responsabile.getIdResponsabile());
            statement.setString(2, responsabile.getNome());
            statement.setString(3, responsabile.getCognome());
            statement.setString(4, responsabile.getMil());
            statement.executeUpdate();

        }

    }

    @override
    public Responsabile trovaPerID(String idResponsabile) throws SQLException{
        String sql = "SELECT * FROM Meccanico WHERE idResponsabile = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, idResponsabile);

            try(ResultSet result =  statement.executeQuery()){
                if(result.next()){
                    return estraiResponsabile(result);
                }
            }
        }
        return null;
    }

    @override

    public boolean delete(String idResponsabile) throws SQLException{
        String sql = "DELETE FROM Responsabile WHERE idResponsabile =?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, idResponsabile);
            statement.executeUpdate();
        }
        return  true;
    }

    @override
    public List<Responsabile> findALL() throws SQLException{
        List<Responsabile> lista = new ArrayList<>();
        String sql = "SELECT * FROM Responsabile";

        try(Statement statement = connection.createStatement;
        ResultSet result = statement.executeQuery(sql)){
            while (result.next()){
                lista.add(estraiResponsabile(result));
            }
        }
        return lista;
    }

    private Responsabile estraiResponsabile(ResultSet result) throws SQLException{
        return new Responsabile(
                result.getString("idResponsabile"),
                result.getString("nome"),
                result.getString("cognome")
        );

    }
}
