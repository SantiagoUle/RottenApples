package model;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name="comentarios")

public class Comment implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private int idComentario;
    
    @Column (name="Cuerpo")//no es necesario pero mejor ponerlo
    private String cuerpoComentario;
    
    @Column(name="Valoracion")
    private boolean valComentario;
    
    @Column(name="FechaCreacion")
    private Date fechaComentario;
    
    @JoinColumn(name="IdUsuario")
    @ManyToOne
    private User usuarioComentario;
    
    @JoinColumn(name="IdReview")
    @ManyToOne
    private Post reviewComentario;

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getCuerpoComentario() {
        return cuerpoComentario;
    }

    public void setCuerpoComentario(String cuerpoComentario) {
        this.cuerpoComentario = cuerpoComentario;
    }

    public boolean isValComentario() {
        return valComentario;
    }

    public void setValComentario(boolean valComentario) {
        this.valComentario = valComentario;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public User getUsuarioComentario() {
        return usuarioComentario;
    }

    public void setUsuarioComentario(User usuarioComentario) {
        this.usuarioComentario = usuarioComentario;
    }

    public Post getReviewComentario() {
        return reviewComentario;
    }

    public void setReviewComentario(Post reviewComentario) {
        this.reviewComentario = reviewComentario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idComentario;
        hash = 67 * hash + Objects.hashCode(this.cuerpoComentario);
        hash = 67 * hash + (this.valComentario ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.fechaComentario);
        hash = 67 * hash + Objects.hashCode(this.usuarioComentario);
        hash = 67 * hash + Objects.hashCode(this.reviewComentario);
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
        final Comment other = (Comment) obj;
        if (this.idComentario != other.idComentario) {
            return false;
        }
        if (this.valComentario != other.valComentario) {
            return false;
        }
        if (!Objects.equals(this.cuerpoComentario, other.cuerpoComentario)) {
            return false;
        }
        if (!Objects.equals(this.fechaComentario, other.fechaComentario)) {
            return false;
        }
        if (!Objects.equals(this.usuarioComentario, other.usuarioComentario)) {
            return false;
        }
        if (!Objects.equals(this.reviewComentario, other.reviewComentario)) {
            return false;
        }
        return true;
    }
    
}