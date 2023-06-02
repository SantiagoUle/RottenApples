package controller;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.Comment;
import EJB.CommentFacadeLocal;

/**
 *
 * @author Santiago
 */
@Named
@ViewScoped
public class AltaCommentController implements Serializable{
    
    private Comment com;

    @EJB
    private CommentFacadeLocal comEJB;
    
    @PostConstruct//es lo primero que se ejecuta de todo
    public void init(){
        com = new Comment();
    }
    
    public void insertarComentario(){
        try{
            comEJB.create(com);
        }catch(Exception e){
            System.out.println("ERROR al insertar comentario/n" +e.getMessage());
        }
    }

    public Comment getCom() {
        return com;
    }

    public void setCom(Comment com) {
        this.com = com;
    }

    public CommentFacadeLocal getComEJB() {
        return comEJB;
    }

    public void setComEJB(CommentFacadeLocal comEJB) {
        this.comEJB = comEJB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.com);
        hash = 97 * hash + Objects.hashCode(this.comEJB);
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
        final AltaCommentController other = (AltaCommentController) obj;
        if (!Objects.equals(this.com, other.com)) {
            return false;
        }
        if (!Objects.equals(this.comEJB, other.comEJB)) {
            return false;
        }
        return true;
    }

}
