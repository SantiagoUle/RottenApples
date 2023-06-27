package EJB;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Rol;

/**
 *
 * @author Cesar
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> implements RolFacadeLocal {

    @PersistenceContext(unitName = "RottenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }
    
    @Override
    public List<Rol> findByName(String rol)
    {
        List<Rol> rolList = new ArrayList<>();
        
        try {
            String consulta = "FROM Rol ur WHERE ur.descripcion LIKE ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, rol);
           
            rolList = query.getResultList();
            if (!rolList.isEmpty()) {
                System.out.println("ENCONTRADO");

            }
        } catch (Exception e) {
            System.out.println("Error al obtener el modelo");
            System.err.println(e);
        }        
        return rolList;
    }
    
    
}
