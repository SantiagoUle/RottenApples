package tool;

import java.io.Serializable;
import model.Usuario;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Cesar
 */
@ManagedBean
@SessionScoped
public class SessionTool implements Serializable{
    public final static String USER_KEY = "usuario";

}