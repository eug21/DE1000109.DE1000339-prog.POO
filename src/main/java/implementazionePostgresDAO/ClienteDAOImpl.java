package implementazionePostgresDAO;

import dao.ClienteDAO;
import model.Cliente;
import model.TipoPatente;
import database.ConnessioneDatabase;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class ClienteDAOImpl implements ClienteDAO {

    private Connection connection;
    public ClienteDAOImpl(){
        try{
            connection = ConnessioneDatabase.getInstance().connection;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void save(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nome, cognome, codiceFiscale, tipoPatente, numeroPatente)" + "VALUES (?, ?, ?, ?, ?) ";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCognome());
            statement.setString(3, cliente.getCodiceFiscale());
            statement.setString(4, String.valueOf(cliente.getTipoPatente()));
            statement.setString(5, cliente.getNumeroPatente());
            statement.executeUpdate();
        }

    }

    @Override
    public Cliente trovaPerPatente(String numeroPatente) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE numeroPatente = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, numeroPatente);
            try(ResultSet result = statement.executeQuery()){
                if(result.next()){
                    return estraiResultCliente(result);
                }
            }

        }
        return null;
    }

    @Override
    public boolean delete(String numeroPatente) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE numeroPatente= ? ";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, numeroPatente);
            statement.executeUpdate();
        }

        return false;
    }

    @Override
    public List<Cliente> findAll() throws SQLException {
        String sql = "SELECT * FROM Cliente";
        List <Cliente> lista = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet result = statement.executeQuery();

            while(result.next()){
                lista.add(estraiResultCliente(result)   );
            }
        }
        return lista;
    }

    private Cliente estraiResultCliente(ResultSet result)throws SQLException{
        return new Cliente(result.getString("nome") , result.getString("cognome"), result.getString("codiceFiscale"), TipoPatente.valueOf(result.getString("tipoPatente")), result.getString("numeroPatente"));
    }
}
