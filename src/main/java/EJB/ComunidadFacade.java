package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Comunidad;

/**
 *
 * @author Santiago
 */
@Stateless
public class ComunidadFacade extends AbstractFacade<Comunidad> implements ComunidadFacadeLocal {

    @PersistenceContext(unitName = "RottenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComunidadFacade() {
        super(Comunidad.class);
    }

}
