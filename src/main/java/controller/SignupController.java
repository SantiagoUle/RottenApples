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
    
    public void insertarUser(){
        try{
            user.setFechaCreacion(new Date());
            userEJB.create(user);
        }catch(Exception e){
            System.out.println("ERROR al insertar user/n" +e.getMessage());
        }
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
