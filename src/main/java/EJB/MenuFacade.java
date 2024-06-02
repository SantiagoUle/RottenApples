package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Menu;
import model.User;

/**
 *
 * @author Cesar
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu> implements MenuFacadeLocal {

    @PersistenceContext(unitName = "RottenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<Menu> obtenerMenususuario(User us){
        
        return null;
    }
    
    public MenuFacade() {
        super(Menu.class);
    }

}
