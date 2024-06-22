package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Comment;
import model.Post;

/**
 *
 * @author Cesar
 */
@Stateless
public class CommentFacade extends AbstractFacade<Comment> implements CommentFacadeLocal {

    @PersistenceContext(unitName = "RottenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentFacade() {
        super(Comment.class);
    }

    @Override
    public List<Comment> findByPost(Post post) {
        List<Comment> listComments=null;
        try {
            String consulta = "SELECT u FROM Comment u WHERE u.reviewComentario=:param1";
            //String consulta = "SELECT u FROM usuarios u WHERE u.Username = '" + user.getUsername() + "' AND u.Password = '" + user.getPassword() + "' ";

            Query query =em.createQuery(consulta);
            query.setParameter("param1",post);
            listComments = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listComments;
    }

}
