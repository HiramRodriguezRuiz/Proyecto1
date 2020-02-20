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

/**
 *
 * @author labcisco
 */
public class SalidasDAO extends BaseDAO{
    
       
    public void guardarSalida(Salida salida){
        try{
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            String insert = String.format("INSERT INTO salidas(fechaHora,destino,idbarcos) VALUES('%s','%s','%s');",salida.getFechaHora(),salida.getDestino(),salida.getIdBarco());
            comando.executeUpdate(insert);
            conn.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());            
        }
    }
        
    public void actualizarSalida(Salida salida){
        try{
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            String update = String.format("UPDATE salidas SET salidas.destino = '%s', salidas.fechaHora = '%s', salidas.idbarcos = %d  WHERE salidas.idsalidas = %d;", 
                    salida.getDestino(), salida.getFechaHora(), salida.getIdBarco(), salida.getIdSalida());
            comando.executeUpdate(update);
            conn.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());            
        }
    }
    
    public boolean eliminarSalida(Integer idSalida){
        try{
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            String delete = String.format("delete from salidas where idsalidas = %s", idSalida);
            comando.executeUpdate(delete);
            conn.close();
            return true;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());     
            return false;
        }
    }
    
     public Salida obtenerSalidasPorId(Integer id){
        Salida salida = new Salida();
        Connection conn = null;
        try{
            conn = this.getConnection();
            Statement comando = conn.createStatement();
            ResultSet resultado;
            resultado = comando.executeQuery("SELECT salidas.idsalidas, salidas.fechaHora,salidas.destino,salidas.idbarcos,barcos.nombre,socios.nombre FROM salidas INNER JOIN barcos INNER JOIN socios WHERE salidas.idbarcos = barcos.idbarcos AND barcos.idsocios = socios.idsocios AND salidas.idsalidas = "+id);
                      
            if(resultado.next()){
                salida.setIdSalida(resultado.getInt("salidas.idsalidas"));
                salida.setDestino(resultado.getString("salidas.destino"));
                salida.setFechaHora(resultado.getString("salidas.fechaHora"));
                salida.setIdBarco(resultado.getInt("salidas.idbarcos"));
                salida.setBarco(resultado.getString("barcos.nombre"));
                salida.setSocio(resultado.getString("socios.nombre"));
            }            
            return salida;
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
    public List<Barco> obtenerBarcosComboBox(){
        ArrayList<Barco> barcos = new ArrayList<>();
        Connection conn = null;
        try{
            conn = this.getConnection();
            Statement comando = conn.createStatement();
            ResultSet resultado;
            resultado = comando.executeQuery("SELECT barcos.nombre, socios.nombre FROM barcos INNER JOIN socios WHERE barcos.idsocios = socios.idsocios  ;");     
            while(resultado.next()){
               Barco barco= new Barco();
               barco.setNombre(resultado.getString("barcos.nombre"));
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
    
     public Barco obtenerBarcosPorNombre(String nombre){
           
        Connection conn = null;
        try{
            conn = this.getConnection();
            Statement comando = conn.createStatement();
            ResultSet resultado;
         resultado = comando.executeQuery("SELECT barcos.idbarcos FROM barcos WHERE barcos.nombre = '"+nombre+"' ;");     
             if(resultado.next()){
                 Barco barco=new Barco();
                 barco.setIdbarcos(resultado.getInt("barcos.idbarcos"));
                 return barco;
             }      
           return null;
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
    
    public List<Salida> obtenerSalidas(String textoBusqueda){
        ArrayList<Salida> salidas = new ArrayList<>();
        Connection conn = null;
        try{
            conn = this.getConnection();
            Statement comando = conn.createStatement();
            ResultSet resultado;
               if(textoBusqueda == null || textoBusqueda.isEmpty()){
                resultado = comando.executeQuery("SELECT salidas.idsalidas, salidas.fechaHora, salidas.destino, salidas.idbarcos, barcos.nombre, socios.nombre FROM salidas INNER JOIN barcos INNER JOIN socios WHERE salidas.idbarcos = barcos.idbarcos AND barcos.idsocios = socios.idsocios  ;");
            }else{
                resultado = comando.executeQuery("SELECT salidas.idsalidas, salidas.fechaHora, salidas.destino, salidas.idbarcos, barcos.nombre, socios.nombre FROM salidas INNER JOIN barcos INNER JOIN socios WHERE salidas.idbarcos = barcos.idbarcos AND barcos.idsocios = socios.idsocios  AND destino LIKE '%" + textoBusqueda + "%';");
            }           
            while(resultado.next()){
                Salida salida = new Salida();
                salida.setIdSalida(resultado.getInt("salidas.idsalidas"));
                salida.setDestino(resultado.getString("salidas.destino"));
                salida.setFechaHora(resultado.getString("salidas.fechaHora"));
                salida.setIdBarco(resultado.getInt("salidas.idbarcos"));
                salida.setBarco(resultado.getString("barcos.nombre"));
                salida.setSocio(resultado.getString("socios.nombre"));
                salidas.add(salida);
            }            
            return salidas;
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
}
