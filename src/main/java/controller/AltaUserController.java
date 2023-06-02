package controller;

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
public class AltaUserController implements Serializable{

    private User user;
    
    @EJB
    private UserFacadeLocal userEJB;
    
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
        final AltaUserController other = (AltaUserController) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.userEJB, other.userEJB)) {
            return false;
        }
        return true;
    }
    
}
