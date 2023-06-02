/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import model.User;

/**
 *
 * @author Yago
 */
@Local
public interface UserFacadeLocal {

    void create(User usuario);

    void edit(User usuario);

    void remove(User usuario);

    User find(Object id);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();
    
}
