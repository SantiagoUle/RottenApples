package controller;

import EJB.MenuFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Menu;
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
@SessionScoped
public class MenuController implements Serializable {
    
    @EJB
    private MenuFacadeLocal menuEJB;
    private List<Menu> lista;
    private MenuModel modelo;
    
    
    @PostConstruct
    public void init() {
        this.menuList();
        modelo = new DefaultMenuModel();
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
        for(Menu m : lista){
            if(m.getTipo().equals("S")){
                DefaultSubMenu firstSubmenu = new DefaultSubMenu().builder().label(m.getNombreMenu()).build();
                for(Menu i : lista){
                    Menu submenu = i.getMenu_Menu();
                    if(submenu != null){
                        if(submenu.getIdMenu() == m.getIdMenu()){
                            DefaultMenuItem item = new DefaultMenuItem().builder().value(i.getNombreMenu()).url(i.getUrlMenu()).build();
                            //firstSubmenu.addElement(item);
                        }
                    }
                }
            }
        }
    }
    
    public void establecerPermisos() {
        User us = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        
        for (Menu m : lista) {
            if (m.getTipo().equals("S") && m.getTipo().equals(us.getIdRol().getTipoUsuario())) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getNombreMenu());
                for (Menu i : lista) {
                    Menu submenu = i.getSubmenu();
                    if (submenu != null) {
                        if (submenu.getCodigo() == m.getCodigo()) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                            item.setUrl(i.getUrl());
                            firstSubmenu.addElement(item);
                        }
                    }
                }
                model.addElement(firstSubmenu);
            } else {
                if (m.getSubmenu() == null && m.getTipoUsuario().equals(us.getTipo())) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                    item.setUrl(m.getUrl());
                    model.addElement(item);
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
