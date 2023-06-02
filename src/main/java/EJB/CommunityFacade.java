package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Community;

/**
 *
 * @author Santiago
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

}
