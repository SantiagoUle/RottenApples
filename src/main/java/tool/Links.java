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
    public static String HOME = "\\RottenApples\\faces\\public\\index.xhtml";
    public static String PROFILE = "\\RottenApples\\faces\\private\\users\\profileClient.xhtml";
    public static String NEWPOST = "\\RottenApples\\faces\\private\\users\\newPost.xhtml";
    public static String HOT = "\\RottenApples\\faces\\public\\hot.xhtml";
    public static String COMMUNITIES = "\\RottenApples\\faces\\public\\communities.xhtml";
    public static String LOGIN = "\\RottenApples\\faces\\public\\loginn.xhtml";
    public static String REGISTER = "\\RottenApples\\faces\\public\\signup.xhtml";
    public static String ERROR = "\\RottenApples\\faces\\public\\error.xhtml";
}
