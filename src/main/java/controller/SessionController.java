package controller;

import EJB.UserFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("\\RottenApples\\faces\\private\\users\\newPost.xhtml");
            } catch (IOException e) {
                // Handle the exception
            }
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("\\RottenApples\\faces\\public\\loginn.xhtml");
            } catch (IOException e) {
                // Handle the exception
            }
        }
    }
    
        public void buttonProfile() {
        //HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        
        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", true);
        
        //Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        loggedIn = false;
        
        //if (loggedIn) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("\\RottenApples\\faces\\private\\users\\profileClient.xhtml");
            } catch (IOException e) {
                // Handle the exception
            }
        //} else {
         //   try {
         //       FacesContext.getCurrentInstance().getExternalContext().redirect("\\RottenApples\\faces\\public\\loginn.xhtml");
          //  } catch (IOException e) {
                // Handle the exception
         //   }
        //}
    }
    
    
    
}

