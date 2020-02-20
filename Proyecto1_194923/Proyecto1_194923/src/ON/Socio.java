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
public class Socio {
    private int id;
    private String nombre;
    private String dni;

    public Socio() {}

    public Socio(Integer id) {
        this.id = id;
    }

    public Socio(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }        
    
    public Socio(int id, String nombre, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
    }   

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Socio other = (Socio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }     
    
    public Object[] toArray(){
        return new Object[]{
            this.getId(),
            this.getNombre(),
            this.getDNI()
        };
    }
}
