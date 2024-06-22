package controller;

import EJB.RolFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.User;
import EJB.UserFacadeLocal;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Rol;
import tool.Links;

/**
 *
 * @author Santiago
 */

@Named
@ViewScoped
public class SignupController implements Serializable{

    private User user;
    private String hideNoSelectOption;
    
    @EJB
    private UserFacadeLocal userEJB;
    
    @EJB
    private RolFacadeLocal rolEJB;
    
    @PostConstruct//es lo primero que se ejecuta de todo
    public void init(){
        user = new User();
    }
    
    public String insertarUser(){
        
        try{
            if (userEJB.checkExistence(user)){
                user.setFechaCreacion(new Date());

                Rol role = rolEJB.find(2);

                user.setIdRol(role);//get rol
                //System.out.println("antes de la creacion");
                userEJB.create(user);
            }else{
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "User not available", "User is already registered");
                FacesContext.getCurrentInstance().addMessage("growl", message);
            }
        }catch(Exception e){
            System.out.println("ERROR al insertar user/n" +e.getMessage());
        }
        return Links.LOGIN;
    }

    public String getHideNoSelectOption() {
        
        return hideNoSelectOption;
    }

    public void setHideNoSelectOption(String hideNoSelectOption) {
        this.hideNoSelectOption = hideNoSelectOption;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserFacadeLocal getUserEJB() {
        return userEJB;
    }

    public void setUserEJB(UserFacadeLocal userEJB) {
        this.userEJB = userEJB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.user);
        hash = 97 * hash + Objects.hashCode(this.userEJB);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SignupController other = (SignupController) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.userEJB, other.userEJB)) {
            return false;
        }
        return true;
    }
    
}
