package implementazionePostgresDAO;

import dao.MeccanicoDAO;
import model Meccanico;
import database.ConnessioneDatabase;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MeccanicoDAOImpl implementsMeccanicoDAO{

    private Connection connection;

    public MeccanicoDAOImpl(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Ovveride
    public void save(Meccanico meccanico) throws SQLException {
        String sql ="INSERT INTO Meccanico (idMeccanico, nome, cognome) VALUES (?,?,?)";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, Meccanico.getIdMeccanico());
            statement.setString(2, Meccanico.getNome());
            statement.setString(3, Meccanico.getCognome());

            statement.executeUpdate();

        }

    }

    @override
    public Meccanico trovaPerID(String idMeccanico) throws SQLException{
        String sql = "SELECT * FROM Meccanico WHERE idMeccanico = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, idMeccanico);

            try(ResultSet result =  statement.executeQuery()){
                if(result.next()){
                    return estraiMeccanico(result);
                }
            }
        }
        return null;
    }

    @override

    public boolean delete(String idMeccanico) throws SQLException{
        String sql = "DELETE FROM  Meccanico WHERE idMeccanico =?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, idMeccanico);
            statement.executeUpdate();
        }
        return  true;
    }

    @override
    public List<Meccanico> findAll() throws SQLException{
        List<Meccanico> lista = new ArrayList<>();
        String sql = "SELECT * FROM Meccanico";

        try(Statement statement = connection.createStatement;
            ResultSet result = statement.executeQuery(sql)){
            while (result.next()){
                lista.add(estraiMeccanico(result));
            }
        }
        return lista;
    }

    private Meccanico estraiMeccanico(ResultSet result) throws SQLException{
        return new Meccanico(
                result.getString("idMeccanico"),
                result.getString("nome"),
                result.getString("cognome")
        );

    }
}
