/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ON;
 
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Martha
 */
public class Barco {
    private int matricula;
    private String nombre;
    private int no_Amarre;
    private int cuota;
    
    java.util.Date utilDate = new java.util.Date();
    long lnMilisegundos = utilDate.getTime();
    java.sql.Date sqlDateOut = new java.sql.Date(lnMilisegundos);
    java.sql.Time sqlTimeOut = new java.sql.Time(lnMilisegundos);

    public Barco() {}

    public Barco(int matricula, String nombre, int no_Amarre, int cuota) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.no_Amarre = no_Amarre;
        this.cuota = cuota;
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNo_Amarre() {
        return no_Amarre;
    }

    public void setNo_Amarre(int no_Amarre) {
        this.no_Amarre = no_Amarre;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public Date getUtilDate() {
        return utilDate;
    }

    public void setUtilDate(Date utilDate) {
        this.utilDate = utilDate;
    }

    public long getLnMilisegundos() {
        return lnMilisegundos;
    }

    public void setLnMilisegundos(long lnMilisegundos) {
        this.lnMilisegundos = lnMilisegundos;
    }

    public java.sql.Date getSqlDateOut() {
        return sqlDateOut;
    }

    public void setSqlDateOut(java.sql.Date sqlDateOut) {
        this.sqlDateOut = sqlDateOut;
    }

    public Time getSqlTimeOut() {
        return sqlTimeOut;
    }

    public void setSqlTimeOut(Time sqlTimeOut) {
        this.sqlTimeOut = sqlTimeOut;
    }
    
    
    
}
