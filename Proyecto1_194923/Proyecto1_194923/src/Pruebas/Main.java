package Pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      try {
            String cadenaConexion = "jdbc:mysql://localhost/clubnautico?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
          try (Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "1234")) {
              Statement comando = conexion.createStatement();
              comando.executeUpdate("insert into socios(dni, nombre) values ('PRT','John')");
          }
            System.out.println("se registraron los datos");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
  
    }    
    
}
