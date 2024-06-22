package controller;

import EJB.CommunityFacadeLocal;
import EJB.UserFacadeLocal;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Community;
import model.User;


/**
 *
 * @author Santiago
 */
@Named
@ViewScoped
public class CommunityController implements Serializable {

    @EJB
    private CommunityFacadeLocal comFacade;
    @EJB
    private UserFacadeLocal userFacade;

    @Inject
    private User user;
    private List<Community> list;

    @PostConstruct//es lo primero que se ejecuta de todo
    public void init() {
        user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        list = comFacade.findAll();
    }
    public String buttonIcon(Community communities){
        String icon = null;
        try{
            System.out.println("llama a icon");
            if ( communities.equals(user.getIdComunidad())){
                icon = "pi pi-heart-fill";
            } else {
                icon = "pi pi-heart";
            }
        }catch(Exception e){
            
        }
        return icon;
    }
    public String buttonBackground(Community communities){
        String icon = null;
        try{
            System.out.println("llama communities bg");
            if (communities.equals(user.getIdComunidad())){
                icon = "background-color: #990000";
            } else {
                icon = "background-color: grey";
            }
        }catch(Exception e){
            
        }
        return icon;
    }

    public void fav(Community communities){
        try{
            System.out.println("BOTON");
            if (communities.equals(user.getIdComunidad())){
                user.setIdComunidad(null);
                userFacade.edit(user);
            } else {
                user.setIdComunidad(communities);
                userFacade.edit(user);
            }
        }catch(Exception e){
            
        }
    }
    //G&S
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Community> getList() {
        return list;
    }

    public void setList(List<Community> list) {
        this.list = list;
    }

}
//<!--<p:commandButton icon="#{communityController.buttonIcon(communities)}"  style="#{communityController.buttonBackground(communities)}" action="#{communityController.change(communities)}"/>-->