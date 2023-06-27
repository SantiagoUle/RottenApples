package controller;

import EJB.UserFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.User;

/**
 *
 * @author Cesar
 */

@ManagedBean
@SessionScoped
public class SessionController {
    @EJB
    private UserFacadeLocal userEJB;
    
    private User user;
    
    private boolean loggedIn;
    
    public boolean isLoggedIn(){
        return loggedIn;
    }
    
    public void buttonNewPost() {
        if (loggedIn) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("\\RottenApples\\faces\\private\\users\\newPost.xhtml");
            } catch (IOException e) {
                // Handle the exception
            }
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("C:\\RottenApples\\faces\\public\\login.xhtml");
            } catch (IOException e) {
                // Handle the exception
            }
        }
    }
    
        public void buttonProfile() {
        if (loggedIn) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("\\RottenApples\\faces\\private\\users\\profileClient.xhtml");
            } catch (IOException e) {
                // Handle the exception
            }
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("C:\\RottenApples\\faces\\public\\login.xhtml");
            } catch (IOException e) {
                // Handle the exception
            }
        }
    }
    
    
    
}

