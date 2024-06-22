package controller;

import EJB.ItemFacadeLocal;
import EJB.PostFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Item;
import model.Post;
import model.User;
import tool.Links;

/**
 *
 * @author Cesar
 */
@Named
@ViewScoped
public class FeedController implements Serializable{

    @EJB
    private PostFacadeLocal postFacade;
    
    @Inject
    private User user;
    private List<Post> list;
    
    private int selectedPostId;
    
    @PostConstruct//es lo primero que se ejecuta de todo
    public void init(){
        user =  (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        list = postFacade.findAll();
    }
    
    public void showDetails(int a){
        selectedPostId = a;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(Links.POST);
        } catch (IOException ex) {
            Logger.getLogger(FeedController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void triLoadPost(int a) {
        selectedPostId = a;
    }
    
    //G&S
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Post> getList() {
        return list;
    }

    public void setList(List<Post> list) {
        this.list = list;
    }

    public int getSelectedPostId() {
        return selectedPostId;
    }

    public void setSelectedPostId(int selectedPostId) {
        this.selectedPostId = selectedPostId;
    }
    
    
    
}
