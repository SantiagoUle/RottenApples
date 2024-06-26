package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Community;
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
    public User verifyUser(User us) {
        User user = null;
        List<User> listaUsuarios;
        try {
            String consulta = "SELECT u FROM User u WHERE u.username=:param1 and u.password=:param2";
            //String consulta = "SELECT u FROM usuarios u WHERE u.Username = '" + user.getUsername() + "' AND u.Password = '" + user.getPassword() + "' ";

            Query query = em.createQuery(consulta);
            query.setParameter("param1", us.getUsername());
            query.setParameter("param2", us.getPassword());
            listaUsuarios = query.getResultList();
            if (!listaUsuarios.isEmpty()) {
                user = listaUsuarios.get(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    @Override
    public boolean checkExistence(User us) {
        List<User> listaUsuarios;
        try {
            String consulta = "SELECT u FROM User u WHERE u.username=:param1";
            //String consulta = "SELECT u FROM usuarios u WHERE u.Username = '" + user.getUsername() + "' AND u.Password = '" + user.getPassword() + "' ";

            Query query = em.createQuery(consulta);
            query.setParameter("param1", us.getUsername());
            listaUsuarios = query.getResultList();
            if (listaUsuarios.isEmpty()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
