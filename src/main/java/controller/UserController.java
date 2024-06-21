package controller;

import EJB.ItemFacadeLocal;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.Item;

/**
 *
 * @author Cesar
 */
@Named
@ViewScoped
public class UserController implements Serializable{
    
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.item);
        hash = 67 * hash + Objects.hashCode(this.itemEJB);
        return hash;
    }

    
    
}
