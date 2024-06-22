package controller;

import EJB.CommentFacadeLocal;
import EJB.ItemFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Comment;
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
public class CommentController implements Serializable {

    @EJB
    private CommentFacadeLocal commentEJB;
    
    @Inject
    private Comment comment;

    private int idUsuario;
    private int idReview;
    
    private List<Comment> list;

    @PostConstruct
    public void init() {
        
    }
    
    public List<Comment> loadComments(Post post){
        return commentEJB.findByPost(post);
    }
    public void publish(Post post){
        //String dir = "/private/common/feed.xhtml?faces-redirect=true";
        String dir = Links.POST + "?postId=";
        dir += post.getIdReview();
        User us = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        comment.setUsuarioComentario(us);
        comment.setFechaComentario(new Date());
        comment.setReviewComentario(post);
        
        commentEJB.create(comment);
        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect(dir);
        }catch(Exception e){
            
        }
        // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Comentario enviado con éxito"));
        //return dir;
    }
    
    
    // G&S

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public List<Comment> getList() {
        return list;
    }

    public void setList(List<Comment> list) {
        this.list = list;
    }

    
    
}
