package controller;

import EJB.ItemFacadeLocal;
import EJB.RolFacadeLocal;
import EJB.UserFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Item;
import model.Rol;
import model.User;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Santiago
 */
@Named
@ViewScoped
public class AdminController implements Serializable {
    @EJB
    private ItemFacadeLocal itemFacade;
    @EJB
    private UserFacadeLocal userFacade;
    @EJB
    private RolFacadeLocal rolFacade;
    
    @Inject
    private Item item;
    @Inject
    private User user;
    @Inject
    private Rol rol;
    
    
    private List<Item> itemList;
    private List<User> userList;
    private List<Rol> rolList;
    
    @PostConstruct
    public void init(){
        itemList = itemFacade.findAll();
        userList = userFacade.findAll();
        rolList = rolFacade.findAll();
    }
    
    public void editItem(RowEditEvent<Item> event){
        System.out.println("ayuda");
        //FacesMessage msg = new FacesMessage("Item Edited", String.valueOf(event.getObject().getCode()));
        //Item i = (Item) event;
        itemFacade.edit(event.getObject()); 
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void editUser(RowEditEvent<User> event){
        System.out.println("user");
        //FacesMessage msg = new FacesMessage("User Edited", String.valueOf(event.getObject().getCode()));
        userFacade.edit(event.getObject());
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }
    
    
}
