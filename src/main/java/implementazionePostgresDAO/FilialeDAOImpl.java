package implementazionePostgresDAO;

import dao.FilialeDAO;
import model.Filiale;
import database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FilialeDAOImpl implements FilialeDAO {

    private Connection connection;

    public FilialeDAOImpl(){
        try{
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void save(Filiale filiale) throws SQLException {
        String sql = "INSERT INTO Filiale (codiceFiliale, via, citta, cap, numeroTelefono" + "VALUES (?, ?, ?, ?,?)";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, filiale.getCodiceFiliale());
            statement.setString(2, filiale.getVia());
            statement.setString(3, filiale.getCitta());
            statement.setString(4, filiale.getCap());
            statement.setString(5, filiale.getNumeroTelefono());
            statement.executeUpdate();
        }
    }

    @Override
    public Filiale trovaPerCodice(String codiceFiliale) throws SQLException {
        String sql = "SELECT * FROM Filiale WHERE codiceFiliale = ? ";
        try(PreparedStatement statement= connection.prepareStatement(sql)){
            statement.setString(1, codiceFiliale);

            try(ResultSet result = statement.executeQuery()){
                if(result.next()){
                    return estraiResult(result);
                }
            }
        }
        return null;
    }

    @Override
    public void delete(String codiceFiliale) throws SQLException {
        String sql = "DELETE FROM Filiale WHERE codiceFiliale = ? ";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, codiceFiliale);
            statement.executeUpdate();
        }

    }

    @Override
    public void update(Filiale filiale) throws SQLException {
        String sql = "UPDATE Filiale SET via = ? , citta = ? , cap = ?, numeroTelefono = ?" + "WHERE codiceFiliale  = ? ";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, filiale.getVia());
            statement.setString(2, filiale.getCitta());
            statement.setString(3, filiale.getCap());
            statement.setString(4, filiale.getNumeroTelefono());
            statement.setString(5, filiale.getCodiceFiliale());
            statement.executeUpdate();
        }

    }

    @Override
    public List<Filiale> getAll() throws SQLException {
        String sql = "SELECT * FROM Filiale";
        List <Filiale> lista = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet result = statement.executeQuery();

            while(result.next()){
                lista.add(estraiResult(result));
            }
        }
        return lista;
    }

    private Filiale estraiResult(ResultSet result) throws SQLException{
        return new Filiale(result.getString("codiceFiliale"), result.getString("via"), result.getString("citta"), result.getString("cap"), result.getString("numeroTelefono"));
    }
}
