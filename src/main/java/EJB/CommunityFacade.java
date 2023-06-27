package EJB;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Community;

/**
 *
 * @author Cesar
 */
@Stateless
public class CommunityFacade extends AbstractFacade<Community> implements CommunityFacadeLocal {

    @PersistenceContext(unitName = "RottenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommunityFacade() {
        super(Community.class);
    }
    
    @Override
    public Community findByName(String com){
        Community community = new Community();
        
        List<Community> comList = new ArrayList<>();
        
        try {
            String consulta = "FROM Comunidades ur WHERE ur.Nombre LIKE ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, com);
           
            comList = query.getResultList();
            if (!comList.isEmpty()) {
                System.out.println("ENCONTRADO");
                community = comList.get(0);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el modelo");
            System.err.println(e);
        }  
        
        return community;
    }
    
    @Override
    public void createAJoin(Community community){
        
    }
}
