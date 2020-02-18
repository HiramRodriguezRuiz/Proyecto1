/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Martha
 */
public class ConnectionFactory implements I_ConnectionFactory{
    private final String connectionString;
    private final String user;
    private final String password;

    public ConnectionFactory(
            String host,
            String database,
            int port,
            String user, 
            String password) {
        this.user = user;
        this.password = password;
        this.connectionString = 
            String.format("jdbc:mysql://%s:%d/%s?serverTimezone=UTC", 
                    host, port, database);
    }
    @Override
    public Connection getConnection() throws SQLException {
         return DriverManager.getConnection(this.connectionString,
                this.user,
                this.password);
    }
    
}
