package tool;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Cesar
 */
@ManagedBean
@SessionScoped
public class Links implements Serializable{
    public static String HOME = "\\RottenApples\\faces\\public\\index.xhtml?faces-redirect=true";
    public static String PROFILE = "\\RottenApples\\faces\\private\\users\\profileClient.xhtml?faces-redirect=true";
    public static String NEWPOST = "\\RottenApples\\faces\\private\\users\\newPost.xhtml?faces-redirect=true";
    public static String HOT = "\\RottenApples\\faces\\public\\hot.xhtml?faces-redirect=true";
    public static String COMMUNITIES = "\\RottenApples\\faces\\public\\communities.xhtml?faces-redirect=true";
    public static String LOGIN = "\\RottenApples\\faces\\public\\login.xhtml?faces-redirect=true";
    public static String REGISTER = "\\RottenApples\\faces\\public\\signup.xhtml?faces-redirect=true";
    public static String ERROR = "\\RottenApples\\faces\\public\\error.xhtml?faces-redirect=true";
    public static String POST = "\\RottenApples\\faces\\private\\common\\post.xhtml";
}
