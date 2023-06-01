package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Review;

/**
 *
 * @author Santiago
 */
@Stateless
public class ReviewFacade extends AbstractFacade<Review> implements ReviewFacadeLocal {

    @PersistenceContext(unitName = "RottenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReviewFacade() {
        super(Review.class);
    }

}
