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
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Santiago
 */

@Entity
@Table(name="reviews")

public class Post implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReview;

    @Column(name = "Titulo")//no es necesario pero mejor ponerlo
    private String titulo;

    @Column(name = "Cuerpo")
    private String cuerpoReview;

    @Column(name = "Valoracion")
    private boolean valoracionReview;

    @Column(name = "Fecha")
    private Date fechaReview;

    @JoinColumn(name = "IdUsuario")
    @ManyToOne
    private User usuarioReview;

    @JoinColumn(name = "IdItem")
    @ManyToOne
    private Item itemReview;

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpoReview() {
        return cuerpoReview;
    }

    public void setCuerpoReview(String cuerpoReview) {
        this.cuerpoReview = cuerpoReview;
    }

    public boolean isValoracionReview() {
        return valoracionReview;
    }

    public void setValoracionReview(boolean valoracionReview) {
        this.valoracionReview = valoracionReview;
    }

    public Date getFechaReview() {
        return fechaReview;
    }

    public void setFechaReview(Date fechaReview) {
        this.fechaReview = fechaReview;
    }

    public User getUsuarioReview() {
        return usuarioReview;
    }

    public void setUsuarioReview(User usuarioReview) {
        this.usuarioReview = usuarioReview;
    }

    public Item getItemReview() {
        return itemReview;
    }

    public void setItemReview(Item itemReview) {
        this.itemReview = itemReview;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idReview;
        hash = 59 * hash + Objects.hashCode(this.titulo);
        hash = 59 * hash + Objects.hashCode(this.cuerpoReview);
        hash = 59 * hash + (this.valoracionReview ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.fechaReview);
        hash = 59 * hash + Objects.hashCode(this.usuarioReview);
        hash = 59 * hash + Objects.hashCode(this.itemReview);
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
        final Post other = (Post) obj;
        if (this.idReview != other.idReview) {
            return false;
        }
        if (this.valoracionReview != other.valoracionReview) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.cuerpoReview, other.cuerpoReview)) {
            return false;
        }
        if (!Objects.equals(this.fechaReview, other.fechaReview)) {
            return false;
        }
        if (!Objects.equals(this.usuarioReview, other.usuarioReview)) {
            return false;
        }
        if (!Objects.equals(this.itemReview, other.itemReview)) {
            return false;
        }
        return true;
    }
    
    
}
