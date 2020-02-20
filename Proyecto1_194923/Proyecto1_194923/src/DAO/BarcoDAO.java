/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ON.Barco;
import ON.Salida;
import ON.Socio;

/**
 *
 * @author angel
 */
public class BarcoDAO extends BaseDAO{
    
    public void guardarBarco(Barco barco){
        try{
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            String insert = String.format("INSERT INTO barcos(barcos.matricula, barcos.nombre, barcos.numamarre, barcos.cuota, barcos.idsocios) VALUES('%s','%s','%s','%s','%s');", barco.getMatricula(), barco.getNombre(), barco.getNumAmarre(), barco.getCuota(), barco.getIdsocios());
            comando.executeUpdate(insert);
            conn.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());            
        }
    }
    
    public void actualizarBarco(Barco barco){
        try{
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            String update = String.format("UPDATE barcos SET barcos.matricula = '%s', barcos.nombre = '%s', barcos.numamarre = %d, barcos.cuota = %f, barcos.idsocios = %d WHERE barcos.idbarcos = %d;", 
                    barco.getMatricula(), barco.getNombre(), barco.getNumAmarre(), barco.getCuota(), barco.getIdsocios(), barco.getIdbarcos());
            comando.executeUpdate(update);
            conn.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());            
        }
    }
    
    public boolean eliminarBarco(Integer idBarco){
        try{
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            String delete = String.format("delete from barcos where barcos.idbarcos = %s", idBarco);
            comando.executeUpdate(delete);
            conn.close();
            return true;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());     
            return false;
        }
    }
    
    public Barco obtenerBarcoPorId(Integer id){
        Barco barco = new Barco();
        Connection conn = null;
        try{
            conn = this.getConnection();
            Statement comando = conn.createStatement();
            ResultSet resultado;
            resultado = comando.executeQuery("SELECT barcos.idbarcos, barcos.matricula, barcos.nombre, barcos.numamarre, barcos.cuota, barcos.idsocios, socios.nombre FROM barcos INNER JOIN socios WHERE barcos.idsocios = socios.idsocios AND barcos.idbarcos = "+id);
                      
            if(resultado.next()){
                barco.setIdbarcos(resultado.getInt("barcos.idbarcos"));
                barco.setMatricula(resultado.getString("barcos.matricula"));
                barco.setNombre(resultado.getString("barcos.nombre"));
                barco.setNumAmarre(resultado.getInt("barcos.numamarre"));
                barco.setCuota(resultado.getFloat("barcos.cuota"));
                barco.setIdsocios(resultado.getInt("barcos.idsocios"));
                barco.setNombreSocio(resultado.getString("socios.nombre"));
            }            
            return barco;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }finally{
            try{
                conn.close();
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
        }
    }
    
    public List<Barco> obtenerBarcos(String textoBusqueda){
        ArrayList<Barco> barcos = new ArrayList<>();
        Connection conn = null;
        try{
            conn = this.getConnection();
            Statement comando = conn.createStatement();
            ResultSet resultado;
               if(textoBusqueda == null || textoBusqueda.isEmpty()){
                resultado = comando.executeQuery("SELECT barcos.idbarcos, barcos.matricula, barcos.nombre, barcos.numamarre, barcos.cuota, barcos.idsocios, socios.nombre FROM barcos INNER JOIN socios WHERE barcos.idsocios = socios.idsocios;");
            }else{
                resultado = comando.executeQuery("SELECT barcos.idbarcos, barcos.matricula, barcos.nombre, barcos.numamarre, barcos.cuota, barcos.idsocios, socios.nombre FROM barcos INNER JOIN socios WHERE barcos.idsocios = socios.idsocios AND barcos.nombre LIKE '%" + textoBusqueda + "%';");
            }           
            while(resultado.next()){
                Barco barco = new Barco();
                barco.setIdbarcos(resultado.getInt("barcos.idbarcos"));
                barco.setMatricula(resultado.getString("barcos.matricula"));
                barco.setNombre(resultado.getString("barcos.nombre"));
                barco.setNumAmarre(resultado.getInt("barcos.numamarre"));
                barco.setCuota(resultado.getFloat("barcos.cuota"));
                barco.setIdsocios(resultado.getInt("barcos.idsocios"));
                barco.setNombreSocio(resultado.getString("socios.nombre"));
                barcos.add(barco);
            }            
            return barcos;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }finally{
            try{
                conn.close();
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
        }
    }
        
     public List<Socio> obtenerSociosComboBox() {
        ArrayList<Socio> socios = new ArrayList<>();
        Connection conn = null;
        try {
            conn = this.getConnection();
            Statement comando = conn.createStatement();
            ResultSet resultado;
            resultado = comando.executeQuery("SELECT * FROM socios;");
            while (resultado.next()) {
                Socio socio = new Socio(resultado.getInt("idsocios"), resultado.getString("nombre"), resultado.getString("curp"));
                socios.add(socio);
            }
            return socios;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
