package implementazionePostgresDAO;

import dao.MeccanicoDAO;
import model.Meccanico;
import database.ConnessioneDatabase;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class RiparazioneDAOImpl implements RiparazioneDAO{
    private Connection connection;
    public RiparazioneDAOImpl(){
        try{
            connection = ConnessioneDatabase.getInstance().connection;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void save(Riparazione riparazione) throws SQLException{
        String sql="INSERT INTO Riparazione (targaVeicolo, descrizioneProblema, costoStimato, costoFinale, dataRiparazione)" + "VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, riparazione.getTargaVeicolo());
            statement.setString(2, riparazione.getDescrizioneProblema());
            statement.setString(3, riparazione.getCostoStimato());
            statement.setString(4, riparazione.getCostoFinale());
            statement.setString(5, riparazione.getDataRiparazione());
            statement.executeUpdate();
        }
    }

    @Override
    public Riparazione trovaPerTarga(string targaVeicolo) throws SQLException{
        String sql = "SELECT * FROM Riparazione  WHERE targaVeicolo = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, targaVeicolo);

            try(ResultSet result = statement.excuteQuery()) {
                if(result.next()){
                    return estraiRiparazione(result);
                }
            }
        }
        return null;
    }
    @Override
    public List<Riparazione> trovaTutte() throws SQLException {
        List<Riparazione> riparazioni = new ArrayList();
        String sql ="SELECT * FROM Riparazione";
        try (Statement statement = connection.CreateStatement();
        ResultSet result =statement.excuteQuery(sql)){
            while (result.next()){
                riparazioni.add(estraiRiparazione(result));
            }
        }
        return riparazioni;
    }
    @Override
    public void update(Riparazione riparazione) throws SQLException{
        String sql="UPDATE Riparazione SET descrizioneProblema =?, costoFinale=?, dataRiparazione=? WHERE targaVeicolo =?";
    try(PreparedStatement statement = connection.prepareStatement(s1l)) {
        statement.setString(1, riparazione.getDescrizioneProblema());
        statement.setString(2, riparazione.getCostoFinale());
        statement.setString(3, riparazione.getCostoStimato());
        statement.setString(4, riparazione.getDataRiparazione());
        statement.setString(5, riparazione.getTargaVeicolo());
        statement.executeUpdate();
    }

}

    @Override
    public void delete (String targaVeicolo) throws SQLException{
        String sql="DELETE FROM Riparazione WHERE targaVeicolo=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, targaVeicolo);
            statement.executeUpdate();
        }
    }

    private Ripazione estraiRiparazione(ResultSet result) throws SQLException{
        return new Riparazione(
                result.getFloat("costoStimato"),
                result.getString("descrizioneProblema"),
                result.getFloat("costoFinale"),
                result.getDate"dataRiparazione"),
                result.getString("targaVeicolo")
        );
    }
}