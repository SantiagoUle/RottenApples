package controlador;

import EJB.ComentarioFacadeLocal;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Comentario;

/**
 *
 * @author Santiago
 */
@Named
@ViewScoped
public class AltaComentarioController implements Serializable{
    
    private Comentario com;

    @EJB
    private ComentarioFacadeLocal comEJB;
    
    @PostConstruct//es lo primero que se ejecuta de todo
    public void init(){
        com = new Comentario();
    }
    
    public void insertarComentario(){
        try{
            comEJB.create(com);
        }catch(Exception e){
            System.out.println("ERROR al insertar comentario/n" +e.getMessage());
        }
    }

    public Comentario getCom() {
        return com;
    }

    public void setCom(Comentario com) {
        this.com = com;
    }

    public ComentarioFacadeLocal getComEJB() {
        return comEJB;
    }

    public void setComEJB(ComentarioFacadeLocal comEJB) {
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
        final AltaComentarioController other = (AltaComentarioController) obj;
        if (!Objects.equals(this.com, other.com)) {
            return false;
        }
        if (!Objects.equals(this.comEJB, other.comEJB)) {
            return false;
        }
        return true;
    }

}
