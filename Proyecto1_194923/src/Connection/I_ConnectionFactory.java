/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Hiram Rodriguez Ruiz
 */
public interface I_ConnectionFactory {
    Connection getConnection() throws SQLException;
}
