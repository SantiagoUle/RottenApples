package controller;


import EJB.UserFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Date;
import EJB.UserFacadeLocal;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import model.User;

@Named
@SessionScoped
public class LoginController implements Serializable {
    private User user;
    
    @EJB
    private UserFacadeLocal userFacade;
    //private SessionUtil session;

    @PostConstruct
    public void init() {
        /* Esto cerraria la sesion
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        */
        user = new User();
        //role = roleFacade.getRoleById(RoleEnum.USER.ordinal());

    }
/*
    public String login() {
        String direction = "/public/index.xhtml?faces-redirect=true";
        User comprobado = checkUser();
        if (comprobado != null) {
            direction= "/private/users/profileClient.xhtml";
            //FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome ", user.getUsername());

            //System.out.println("olaola");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("User", comprobado);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas"));
            direction= "/public/error.xhtml";
        }

        //FacesContext.getCurrentInstance().addMessage(null, message);
        return direction;
    }

    public User checkUser() {
        User comprobado = null;
        try {
            comprobado = userFacade.verifyUser(user);

        } catch (Exception e) {

        }
        return comprobado;
    }
*/
    public String login() {
        User us = null;
        String direction = null;
        try {
            us = userFacade.verifyUser(user);
            if (us != null) {     
                //Almacenar en la sesión de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("User", us);
                direction = "/private/users/profileClient.xhtml?faces-redirect=true";
                us.setUltimaConexion(new Date());
                userFacade.edit(us);
            } else {
                FacesContext.getCurrentInstance().addMessage("error", new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
        return direction;
    }

    public String moveToEvent() {
        return "event.xhtml";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
