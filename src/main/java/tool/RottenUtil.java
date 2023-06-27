package tool;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class RottenUtil implements Serializable {

    public static String WELLCOME = "/public/index.xhtml?faces-redirect=true";
    public static String SIGNUP = "/public/signup.xhtml";
    public static String ADMIN = "/private/admin.xhtml";
    public static String HOME = "/private/event.xhtml";
    public static String ITEM_CREATION = "/private/itemCreation.xhtml";
    public static String ITEM_LIST = "/private/itemList.xhtml";
    public static String TEMPLATE = "/WEB-INF/template/template.xhtml";
}
