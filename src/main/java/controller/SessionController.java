package controller;

import EJB.UserFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import model.User;
import static tool.Links.*;

/**
 *
 * @author Cesar
 *//*
@ManagedBean
@SessionScoped*/
@Named
@ViewScoped
public class SessionController implements Serializable{

    @EJB
    private UserFacadeLocal userEJB;

    private User user;

    private boolean loggedIn;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void buttonNewPost() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/RottenApples/faces/private/users/newPost.xhtml?faces-redirect=true");
            } catch (IOException e) {
                // Handle the exception
            }
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/RottenApples/faces/public/loginn.xhtml?faces-redirect=true");
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

        if (loggedIn) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(PROFILE);
            } catch (IOException e) {
            }
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(HOME);
            } catch (IOException e) {
            }
        }
    }

    public void verifyUser() {

        try {
            User u = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
            if (u == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect(ERROR);

            }
        } catch (Exception ex) {
            Logger.getLogger(SessionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

