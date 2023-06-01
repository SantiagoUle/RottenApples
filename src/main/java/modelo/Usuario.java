package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cesar
 */

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private int idUsuario;
    
    @Column (name="Username")
    private String username;
    
    @Column(name="Password")
    private String password;
    
    @Column(name="UltimaConexion")
    @Temporal(TemporalType.DATE)
    private Date ultimaConexion;
    
    @Column(name="FechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    
    @JoinColumn(name="IdComunidad")
    @ManyToMany(cascade=CascadeType.PERSIST)
    private Comunidad idComunidad;
    
    @JoinColumn(name="IdRol")
    @OneToOne
    private Rol idRol;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Comunidad getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(Comunidad idComunidad) {
        this.idComunidad = idComunidad;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idUsuario;
        hash = 67 * hash + Objects.hashCode(this.username);
        hash = 67 * hash + Objects.hashCode(this.password);
        hash = 67 * hash + Objects.hashCode(this.ultimaConexion);
        hash = 67 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 67 * hash + Objects.hashCode(this.idComunidad);
        hash = 67 * hash + Objects.hashCode(this.idRol);
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.ultimaConexion, other.ultimaConexion)) {
            return false;
        }
        if (!Objects.equals(this.fechaCreacion, other.fechaCreacion)) {
            return false;
        }
        if (!Objects.equals(this.idComunidad, other.idComunidad)) {
            return false;
        }
        if (!Objects.equals(this.idRol, other.idRol)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
