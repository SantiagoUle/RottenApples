package controller;


import EJB.UserFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import model.User;

@Named
@ViewScoped
public class LoginController implements Serializable {
    private User user;

    @EJB
    private UserFacadeLocal userFacade;
    //private SessionUtil session;

    @PostConstruct
    public void init() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        user = new User();
        //role = roleFacade.getRoleById(RoleEnum.USER.ordinal());

    }

    public String login() {
        FacesMessage message = null;
        String direction = "/public/index.xhtml?faces-redirect=true";
        User comprobado = checkUser();
        if (comprobado != null) {
            //direction= ".\\test\\error.xhtml";
            direction= "/private/users/profileClient.xhtml";
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome ", user.getUsername());

            System.out.println("olaola");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("User", comprobado);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas");
            direction= "/public/index.xhtml";
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
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
