
package ON;

import java.util.Objects;

public class Salida {
    private Integer idSalida, idBarco;
    private String destino, fechaHora, barco, socio;

    public Salida() {
    }

    public Salida(Integer idSalida) {
        this.idSalida = idSalida;
    }
    
    public Salida(String fechaHora, String destino, Integer idBarco) {
        this.idBarco = idBarco;
        this.destino = destino;
        this.fechaHora = fechaHora;
    }

    public Salida(Integer idSalida, Integer idBarco, String destino, String fechaHora, String barco, String socio) {
        this.idSalida = idSalida;
        this.idBarco = idBarco;
        this.destino = destino;
        this.fechaHora = fechaHora;
        this.barco = barco;
        this.socio = socio;
    }

    public Integer getIdSalida() {
        return idSalida;
    }

    public Integer getIdBarco() {
        return idBarco;
    }

    public String getDestino() {
        return destino;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getBarco() {
        return barco;
    }

    public String getSocio() {
        return socio;
    }

    public void setIdSalida(Integer idSalida) {
        this.idSalida = idSalida;
    }

    public void setIdBarco(Integer idBarco) {
        this.idBarco = idBarco;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setBarco(String barco) {
        this.barco = barco;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.idSalida);
        hash = 67 * hash + Objects.hashCode(this.idBarco);
        hash = 67 * hash + Objects.hashCode(this.destino);
        hash = 67 * hash + Objects.hashCode(this.fechaHora);
        hash = 67 * hash + Objects.hashCode(this.barco);
        hash = 67 * hash + Objects.hashCode(this.socio);
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
        final Salida other = (Salida) obj;
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        if (!Objects.equals(this.fechaHora, other.fechaHora)) {
            return false;
        }
        if (!Objects.equals(this.barco, other.barco)) {
            return false;
        }
        if (!Objects.equals(this.socio, other.socio)) {
            return false;
        }
        if (!Objects.equals(this.idSalida, other.idSalida)) {
            return false;
        }
        if (!Objects.equals(this.idBarco, other.idBarco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Salida{" + "idSalida=" + idSalida + ", idBarco=" + idBarco + ", destino=" + destino + ", fechaHora=" + fechaHora + ", barco=" + barco + ", socio=" + socio + '}';
    }
    
        public Object[] toArray(){
        return new Object[]{
            this.getIdSalida(),
            this.getDestino(),
            this.getFechaHora(),
            this.getIdBarco(),
            this.getBarco(),
            this.getSocio()
        };
    }
    
}
