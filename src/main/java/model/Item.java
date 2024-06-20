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
@Table(name="items")

public class Item implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private int idItem;
    
    @Column (name="Nombre")//no es necesario pero mejor ponerlo
    private String nombreItem;
    
    @Column(name="Descripcion")
    private String descriptionItem;

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public String getDescriptionItem() {
        return descriptionItem;
    }

    public void setDescriptionItem(String descriptionItem) {
        this.descriptionItem = descriptionItem;
    }

    @Override
    public String toString(){
        return String.valueOf(idItem);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idItem;
        hash = 67 * hash + Objects.hashCode(this.nombreItem);
        hash = 67 * hash + Objects.hashCode(this.descriptionItem);
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
        final Item other = (Item) obj;
        if (this.idItem != other.idItem) {
            return false;
        }
        if (!Objects.equals(this.nombreItem, other.nombreItem)) {
            return false;
        }
        if (!Objects.equals(this.descriptionItem, other.descriptionItem)) {
            return false;
        }
        return true;
    }
    
}