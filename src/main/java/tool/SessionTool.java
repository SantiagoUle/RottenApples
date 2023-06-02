package tool;

import EJB.RolFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Cesar
 */
@ManagedBean
@SessionScoped
public class SessionTool implements Serializable{
    public final static String USER_KEY = "usuario";
    @EJB
    private RolFacadeLocal userRolEJB;
    
    
    
    
    
    
    public void add(String key, Object value){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("");
        } catch (IOException ex) {
            Logger.getLogger(SessionTool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
