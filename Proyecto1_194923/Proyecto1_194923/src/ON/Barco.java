/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ON;
 
import java.util.Objects;

/**
 *
 * @author Hiram Rodriguez Ruiz
 */
public class Barco {
    private int idBarcos, numAmarre, idSocios;
    private String nombre, matricula, nombreSocio;
    private Float cuota;

    public Barco() {
    }

    public Barco(Integer idbarcos) {
        this.idBarcos = idbarcos;
    }

    public Barco(Integer numAmarre, Integer idsocios, String nombreB, String matricula, Float cuota) {
        this.numAmarre = numAmarre;
        this.idSocios = idsocios;
        this.nombre = nombreB;
        this.matricula = matricula;
        this.cuota = cuota;
    }
    
      public Barco(Integer idbarcos, Integer numAmarre, Integer idsocios, String nombreB, String matricula) {
        this.idBarcos = idbarcos;
        this.numAmarre = numAmarre;
        this.idSocios = idsocios;
        this.nombre = nombreB;
        this.matricula = matricula;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public Integer getIdbarcos() {
        return idBarcos;
    }

    public Integer getNumAmarre() {
        return numAmarre;
    }

    public Integer getIdsocios() {
        return idSocios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public Float getCuota() {
        return cuota;
    }

    public void setIdbarcos(Integer idbarcos) {
        this.idBarcos = idbarcos;
    }

    public void setNumAmarre(Integer numAmarre) {
        this.numAmarre = numAmarre;
    }

    public void setIdsocios(Integer idsocios) {
        this.idSocios = idsocios;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCuota(Float cuota) {
        this.cuota = cuota;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.idBarcos);
        hash = 37 * hash + Objects.hashCode(this.numAmarre);
        hash = 37 * hash + Objects.hashCode(this.idSocios);
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.matricula);
        hash = 37 * hash + Objects.hashCode(this.cuota);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Barco other = (Barco) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.idBarcos, other.idBarcos)) {
            return false;
        }
        if (!Objects.equals(this.numAmarre, other.numAmarre)) {
            return false;
        }
        if (!Objects.equals(this.idSocios, other.idSocios)) {
            return false;
        }
        if (!Objects.equals(this.cuota, other.cuota)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Barco{" + "idbarcos=" + idBarcos + ", numAmarre=" + numAmarre + ", idsocios=" + idSocios + ", nombreB=" + nombre + ", matricula=" + matricula + ", cuota=" + cuota + '}';
    }

    public Object[] toArray(){
        return new Object[]{
            this.getIdbarcos(),
            this.getMatricula(),
            this.getNombre(),
            this.getNumAmarre(),
            this.getCuota(),
            this.getIdsocios(),
            this.getNombreSocio()
        };
    }
}
