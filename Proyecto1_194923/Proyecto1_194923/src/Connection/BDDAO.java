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
 * @author Hiram Rodriguez Ruiz
 */
public abstract class BDDAO {
    private final String cadenaConexion = "jdbc:mysql://localhost/club_nautico?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String usuario = "root";
    private final String password = "1234";
    
    protected Connection getConnection() throws SQLException{
        return DriverManager.getConnection(this.cadenaConexion, 
                this.usuario, this.password);
    }
}
