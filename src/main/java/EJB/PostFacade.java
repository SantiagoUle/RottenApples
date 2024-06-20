package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Post;

/**
 *
 * @author Cesar
 */
@Stateless
public class PostFacade extends AbstractFacade<Post> implements PostFacadeLocal {

    @PersistenceContext(unitName = "RottenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostFacade() {
        super(Post.class);
    }

}
