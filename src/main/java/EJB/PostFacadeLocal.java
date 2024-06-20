/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import model.Post;

/**
 *
 * @author Nomad
 */
@Local
public interface PostFacadeLocal {

    void create(Post review);

    void edit(Post review);

    void remove(Post review);

    Post find(Object id);

    List<Post> findAll();

    List<Post> findRange(int[] range);

    int count();
    
}
