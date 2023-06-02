/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import model.Community;

/**
 *
 * @author Yago
 */
@Local
public interface CommunityFacadeLocal {

    void create(Community community);

    void edit(Community community);

    void remove(Community community);

    Community find(Object id);

    List<Community> findAll();

    List<Community> findRange(int[] range);

    int count();
    
}
