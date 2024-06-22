package controller;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.User;
import tool.Links;

/**
 *
 * @author Santiago
 */
@Named
@ViewScoped
public class SecurityController implements Serializable {

    public void verifySesion() {
        try {
            User us = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");

            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../../public/login.xhtml");
            }

        } catch (Exception e) {

        }
    }

    public void verifyAdmin() {
        try {
            User us = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");

            if (us == null || us.getIdRol().getTipoUsuario() != 'A') {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../../public/login.xhtml");
            }

        } catch (Exception e) {

        }
    }

    public void verifyLogout() {
        try {
            User us = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");

            if (us != null) {
                //intento de entrar al login ya logueado                
                //intento de entrar a signup ya logueado
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../private/users/profileClient.xhtml");
            }

        } catch (Exception e) {

        }
    }

    public String logout() {
        System.out.println("cerrarsesion");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/public/index.xhtml";
    }
}
