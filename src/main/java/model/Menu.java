package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Santiago
 */

@Entity
@Table(name="menus")

public class Menu implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private int idMenu;
    
    @Column (name="nombre")//no es necesario pero mejor ponerlo
    private String nombreMenu;
    
    @Column(name="url")
    private String urlMenu;
    
    @JoinColumn(name="idRol")
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Rol rolMenu;
    
    @JoinColumn(name="idMenu_Menu")
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Menu menu_Menu;

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public String getUrlMenu() {
        return urlMenu;
    }

    public void setUrlMenu(String urlMenu) {
        this.urlMenu = urlMenu;
    }

    public Rol getRolMenu() {
        return rolMenu;
    }

    public void setRolMenu(Rol rolMenu) {
        this.rolMenu = rolMenu;
    }

    public Menu getMenu_Menu() {
        return menu_Menu;
    }

    public void setMenu_Menu(Menu menu_Menu) {
        this.menu_Menu = menu_Menu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idMenu;
        hash = 83 * hash + Objects.hashCode(this.nombreMenu);
        hash = 83 * hash + Objects.hashCode(this.urlMenu);
        hash = 83 * hash + Objects.hashCode(this.rolMenu);
        hash = 83 * hash + Objects.hashCode(this.menu_Menu);
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
        final Menu other = (Menu) obj;
        if (this.idMenu != other.idMenu) {
            return false;
        }
        if (!Objects.equals(this.nombreMenu, other.nombreMenu)) {
            return false;
        }
        if (!Objects.equals(this.urlMenu, other.urlMenu)) {
            return false;
        }
        if (!Objects.equals(this.rolMenu, other.rolMenu)) {
            return false;
        }
        if (!Objects.equals(this.menu_Menu, other.menu_Menu)) {
            return false;
        }
        return true;
    }
    
    
}
