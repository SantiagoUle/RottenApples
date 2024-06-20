package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Santiago
 */

@Entity
@Table(name="comunidades")

public class Community implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private int idComunidad;
    
    @Column (name="Nombre")
    private String nombreComunidad;
    
    @Column(name="Descripcion")
    private String estadoComunidad;

    public int getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(int idComunidad) {
        this.idComunidad = idComunidad;
    }

    public String getNombreComunidad() {
        return nombreComunidad;
    }

    public void setNombreComunidad(String nombreComunidad) {
        this.nombreComunidad = nombreComunidad;
    }

    public String getEstadoComunidad() {
        return estadoComunidad;
    }

    public void setEstadoComunidad(String estadoComunidad) {
        this.estadoComunidad = estadoComunidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idComunidad;
        hash = 17 * hash + Objects.hashCode(this.nombreComunidad);
        hash = 17 * hash + Objects.hashCode(this.estadoComunidad);
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
        final Community other = (Community) obj;
        if (this.idComunidad != other.idComunidad) {
            return false;
        }
        if (!Objects.equals(this.nombreComunidad, other.nombreComunidad)) {
            return false;
        }
        if (!Objects.equals(this.estadoComunidad, other.estadoComunidad)) {
            return false;
        }
        return true;
    }
    
}