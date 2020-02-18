package Pruebas;

import Connection.ConnectionFactory;
import Connection.I_ConnectionFactory;
import DAO.SocioDAO;
import DAO.SocioDAOImpl;

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
        // TODO code application logic here
        I_ConnectionFactory connectionFactory = 
            new ConnectionFactory(
                "localhost", "clubnautico", 3306, "root", "1234");
        
        SocioDAO socioDAO = new SocioDAOImpl(connectionFactory);
    }
    
}
