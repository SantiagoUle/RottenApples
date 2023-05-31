package modelo;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name="reviews")

public class Review implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReview;

    @Column(name = "titulo")//no es necesario pero mejor ponerlo
    private String Review;

    @Column(name = "cuerpo")
    private String cuerpoReview;

    @Column(name = "valoracion")
    private boolean valoracionReview;

    @Column(name = "fecha")
    private Date fechaReview;

    @JoinColumn(name = "idUsuario")
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Usuario usuarioReview;

    @JoinColumn(name = "idItem")
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Item itemReview;

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String Review) {
        this.Review = Review;
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

    public Usuario getUsuarioReview() {
        return usuarioReview;
    }

    public void setUsuarioReview(Usuario usuarioReview) {
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
        hash = 59 * hash + Objects.hashCode(this.Review);
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
        final Review other = (Review) obj;
        if (this.idReview != other.idReview) {
            return false;
        }
        if (this.valoracionReview != other.valoracionReview) {
            return false;
        }
        if (!Objects.equals(this.Review, other.Review)) {
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
