package controller;

import EJB.ItemFacadeLocal;
import EJB.PostFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Item;
import model.Post;
import model.User;

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
    @Inject
    private User user;
    
    private List<Item> categorias;


    
    
    
    
    @PostConstruct
    public void init(){
        categorias = categoriaEJB.findAll();
    }
    
    
    
    public String register(){
        System.out.print("niggs");
        String dir = "/private/common/feed.xhtml?faces-redirect=true";
        postEJB.create(null);
        return dir;
    }
    
    
    
    // G&Ss
    public List<Item> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Item> categorias) {
        this.categorias = categorias;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
