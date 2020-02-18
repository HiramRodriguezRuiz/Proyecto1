/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cntrl;

import java.util.List;
import ON.*;
import DAO.*;
/**
 *
 * @author Martha
 */
public class Control {
    private final SocioDAO sociosDAO;
    
    private final BarcoDAO barcosDAO;

    public Control() {
        this.sociosDAO = new SocioDAO();
        
        this.barcosDAO = new BarcoDAO();
    }

    //-----------------------------------------Control Socios-------------------------------------------------------------------//
    public List<Socio> obtenerSocios(String textoBusqueda) {
        return this.sociosDAO.obtenerSocios(textoBusqueda);
    }

    public void guardarSocio(Socio socio) {
        this.sociosDAO.guardarSocio(socio);
    }

    public void actualizarSocio(Socio socio) {
        this.sociosDAO.actualizarSocio(socio);
    }

    public Socio obtenerSocioPorId(Integer id) {
        return this.sociosDAO.obtenerSocioPorId(id);
    }

    public boolean eliminarSocio(Integer id) {
        return this.sociosDAO.eliminarSocio(id);
    }
    
    //-----------------------------------------Control Barcos-------------------------------------------------------------------//
    public List<Barco> obtenerBarcos(String textoBusqueda) {
        return this.barcosDAO.obtenerBarcos(textoBusqueda);
    }
    
    public void guardarBarco(Barco barco) {
        this.barcosDAO.guardarBarco(barco);
    }
    
    public void actualizarBarco(Barco barco) {
        this.barcosDAO.actualizarBarco(barco);
    }

    public boolean eliminarBarco(Integer idBarco) {
        return this.barcosDAO.eliminarBarco(idBarco);
    }
    
    public Barco obtenerBarcoPorId(Integer id) {
        return this.barcosDAO.obtenerBarcoPorId(id);
    }
    
    public List<Socio> obtenerSociosComboBox() {
        return this.barcosDAO.obtenerSociosComboBox();
    }
}
