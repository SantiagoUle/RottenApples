package controller;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.User;

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
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../../public/error.xhtml");
            }

        } catch (Exception e) {

        }
    }
}
