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
import ON.Socio;
import java.sql.Statement;
/**
 *
 * @author Hiram Rodriguez Ruiz
 */
public class SocioDAOImpl implements SocioDAO{
    private final I_ConnectionFactory connectionFactory;
    
    public SocioDAOImpl(I_ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
    
    @Override
    public Socio find(int matricula) throws Exception {
        final String sql = "SELECT id, nombre, direccion " +
            "FROM socio WHERE id = ?";
        
        try (Connection connection = this.connectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, matricula);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Socio(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("direccion"));
                }
                
                return null;
            }
        }
    }

    @Override
    public List<Socio> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Socio socio) throws Exception {
        final String sql = "INSERT INTO socio (nombre, direccion) " +
            "VALUES (?, ?)";
        try (
            Connection connection = this.connectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, socio.getNombre());
            statement.setString(2, socio.getAge());
            int id = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            socio.setId(id);
        }
    }

    @Override
    public void update(Socio socio) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
