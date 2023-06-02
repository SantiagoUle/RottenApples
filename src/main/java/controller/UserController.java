package controller;

import EJB.UserFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import model.User;

/**
 *
 * @author Cesar
 */

@ManagedBean
@SessionScoped
public class UserController implements Serializable {

    @EJB
    private UserFacadeLocal userEJB;
    
    private User user;
    
    
    public User getUser() {
        user = userEJB.find(1);
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    
}
