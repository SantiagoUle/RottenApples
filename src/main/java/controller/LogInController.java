package controller;


import EJB.UserFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import model.User;

@ManagedBean
@SessionScoped
public class LogInController implements Serializable {
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
        String direction = "/RottenApples/faces/public/loginn.xhtml?faces-redirect=true";
        User comprobado = checkUser();
        if (comprobado != null) {
            direction= "/RottenApples/faces/public/loginn.xhtml?faces-redirect=true";
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome ", user.getUsername());

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("User", comprobado);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas");
            direction= "/RottenApples/faces/public/loginn.xhtml?faces-redirect=true";
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        return direction;
    }

    public User checkUser() {
        User comprobado = null;
        try {
            comprobado = userFacade.getUser(user);
            System.out.println("olaola");

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
