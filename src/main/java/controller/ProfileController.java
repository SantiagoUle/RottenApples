package controller;

import EJB.ItemFacadeLocal;
import EJB.UserFacadeLocal;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
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
//@SessionScoped
public class ProfileController implements Serializable{

    @EJB
    private UserFacadeLocal userEJB;

    @Inject
    private User user;
    
    
    
    @PostConstruct//es lo primero que se ejecuta de todo
    public void init(){
        user =  (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        User u = userEJB.verifyUser(user);
        user = u;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("User", user);
    }

    //G&S

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
