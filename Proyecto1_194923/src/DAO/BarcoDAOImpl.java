/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import Connection.I_ConnectionFactory;
import ON.Barco;
import java.sql.Statement;
/**
 *
 * @author Hiram Rodriguez Ruiz
 */
public class BarcoDAOImpl implements BarcoDAO{
    private final I_ConnectionFactory connectionFactory;
    
    public BarcoDAOImpl(I_ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
    @Override
    public Barco find(int matricula) throws Exception {
        final String sql = "SELECT matricula, nombre, no_Amarre, cuota " +
            "FROM barco WHERE matricula = ?";
        
        try (Connection connection = this.connectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, matricula);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Barco(
                        resultSet.getInt("matricula"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("no_Amarre"),
                        resultSet.getInt("cuota"));
                }
                return null;
            }
        }
    }

    @Override
    public List<Barco> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Barco barco) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Barco barco) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int matricula) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
