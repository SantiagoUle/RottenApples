package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.User;

/**
 *
 * @author Cesar
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "RottenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    @Override
    public User verifyUser(User us){
        User user = null;
        List<User> listaUsuarios;
        try {
            String consulta = "SELECT u FROM usuarios u WHERE u.Username = '" + user.getUsername() + "' AND u.Password = '" + user.getPassword() + "' ";
            Query query = em.createQuery(consulta);
            // query.setParameter(1, usuario.getUsername());
            //query.setParameter(2, usuario.getPassword());
            listaUsuarios = query.getResultList();
            if (!listaUsuarios.isEmpty()) {
                user = listaUsuarios.get(0);
            }
        } catch (Exception e) {}
        return user;
    }
    
}
