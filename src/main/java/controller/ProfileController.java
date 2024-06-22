package controller;

import EJB.ItemFacadeLocal;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Comment;
import model.Item;
import model.User;

/**
 *
 * @author Cesar
 */
@Named
@ViewScoped
public class ProfileController implements Serializable{

    @Inject
    private User user;
    
    
    
    @PostConstruct//es lo primero que se ejecuta de todo
    public void init(){
        user =  (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
    }

    //G&S

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
