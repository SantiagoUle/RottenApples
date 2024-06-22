package controller;

import EJB.MenuFacadeLocal;
import EJB.RolFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.Menu;
import model.Rol;
import model.User;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;

import org.primefaces.model.menu.MenuModel;


/**
 *
 * @author Cesar
 */
@Named
@ViewScoped
public class MenuController implements Serializable {
    
    @EJB
    private MenuFacadeLocal menuEJB;
    @EJB
    private RolFacadeLocal rolEJB;
    
    private List<Menu> lista;
    private MenuModel modelo;
    
    
    @PostConstruct
    public void init() {
        this.menuList();
        modelo = new DefaultMenuModel();
        this.accessLevels();
    }
    
    public void menuList(){
        lista = menuEJB.findAll();
        
    }
    
    public MenuModel obtainMenu(){ // WIP
        // Para los submenus S se utiliza DefaultSubMenu
        DefaultSubMenu subMenu = DefaultSubMenu.builder().label("nombresubmenu").build();
        // Para los items I se utiliza DefaultMenuItem
        DefaultMenuItem item = DefaultMenuItem.builder().value("nombreitem").url("URL").build();
        
        // A los items tambien url de destino
        item.setUrl("salida");
        
        // Si el item tiene padre debe añadirse al submenu de su padre
        subMenu.getElements().add(item);
        
        return null;
    }
    
    public List<Menu> menusToUser(User us){ // Devuelve lista de menús dado el nivel de acceso del usuario
        
        
        return null;
    }
    
    public void accessLevels(){
        
        User us = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        if(us == null){
            us = new User();
            Rol rol = rolEJB.find(3);
            us.setIdRol(rol);
            
        }
        
        for(Menu m : lista){
            if(m.getTipo().equals("S") && m.getRolMenu().getTipoUsuario().equals(us.getIdRol().getTipoUsuario())){
                DefaultSubMenu firstSubmenu = new DefaultSubMenu().builder().label(m.getNombreMenu()).build();
                for(Menu i : lista){
                    Menu submenu = i.getMenu_Menu();
                    if(submenu != null){
                        if(submenu.getIdMenu() == m.getIdMenu()){
                            DefaultMenuItem item = new DefaultMenuItem().builder().value(i.getNombreMenu()).url(i.getUrlMenu()).build();
                            item.setUrl(i.getUrlMenu());
                            firstSubmenu.getElements().add(item);
                        }
                    }
                }
                
                modelo.getElements().add(firstSubmenu);
            } else {
                if(m.getMenu_Menu() == null && m.getRolMenu().getTipoUsuario().equals(us.getIdRol().getTipoUsuario())){
                    DefaultMenuItem item = new DefaultMenuItem().builder().value(m.getNombreMenu()).url(m.getUrlMenu()).build();
                    item.setUrl(m.getUrlMenu());
                    modelo.getElements().add(item);
                }
            }
        }
    }
    
    
    
    

    // G&S

    public MenuFacadeLocal getMenuEJB() {
        return menuEJB;
    }

    public void setMenuEJB(MenuFacadeLocal menuEJB) {
        this.menuEJB = menuEJB;
    }

    public MenuModel getModelo() {
        return modelo;
    }

    public void setModelo(MenuModel modelo) {
        this.modelo = modelo;
    }
    
    
}
