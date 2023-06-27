package controller;

import EJB.UserFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.User;

/**
 *
 * @author Cesar
 */

@Named
@ViewScoped
public class IndexController implements Serializable{
    @EJB
    private UserFacadeLocal userEJB;
    
    private User user;
    
    private boolean loggedIn;
    
    public String verifyUser() {
        
        
        
        return null;
    }
    
    
    
    
}

