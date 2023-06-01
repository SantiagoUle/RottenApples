package controlador;

import EJB.ItemFacadeLocal;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Item;

/**
 *
 * @author Santiago
 */
@Named
@ViewScoped
public class AltaItemController implements Serializable{
    
    private Item item;

    @EJB
    private ItemFacadeLocal itemEJB;
    
    @PostConstruct//es lo primero que se ejecuta de todo
    public void init(){
        item = new Item();
    }
    
    public void insertarItem(){
        try{
            itemEJB.create(item);
        }catch(Exception e){
            System.out.println("ERROR al insertar item/n" +e.getMessage());
        }
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemFacadeLocal getItemEJB() {
        return itemEJB;
    }

    public void setItemEJB(ItemFacadeLocal itemEJB) {
        this.itemEJB = itemEJB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.item);
        hash = 67 * hash + Objects.hashCode(this.itemEJB);
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
        final AltaItemController other = (AltaItemController) obj;
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        if (!Objects.equals(this.itemEJB, other.itemEJB)) {
            return false;
        }
        return true;
    }
    
    
}
