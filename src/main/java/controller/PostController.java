package controller;

import EJB.ItemFacadeLocal;
import EJB.PostFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Item;
import model.Post;
import model.User;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Cesar
 */
@Named
@ViewScoped
public class PostController implements Serializable {

    @EJB
    private PostFacadeLocal postEJB;
    @EJB
    private ItemFacadeLocal categoriaEJB;

    @Inject
    private Post post;
    @Inject
    private Item item;

    private List<Item> categorias;
    
    private Post selectedPost; // Post seleccionado
    private int selectedPostId; // ID del post seleccionado

    @PostConstruct
    public void init() {
        categorias = categoriaEJB.findAll();
    }

    public String register() {
        String dir = "/private/common/feed.xhtml?faces-redirect=true";

        User us = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");

        post.setItemReview(item);
        post.setUsuarioReview(us);
        post.setFechaReview(new Date());
        
        postEJB.create(post);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "aoa"));
        return dir;

    }
    
    public void loadPost() {
            System.out.println("El id NOOOOOOO es null");
            selectedPost = postEJB.find(selectedPostId);
    }
    public void triLoadPost(){
        selectedPostId = this.getPost().getIdReview();
    }

    // G&S

    public Post getSelectedPost() {
        return selectedPost;
    }

    public void setSelectedPost(Post selectedPost) {
        this.selectedPost = selectedPost;
    }

    public int getSelectedPostId() {
        return selectedPostId;
    }

    public void setSelectedPostId(int selectedPostId) {
        this.selectedPostId = selectedPostId;
    }
    
    
    
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Item> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Item> categorias) {
        this.categorias = categorias;
    }

}
