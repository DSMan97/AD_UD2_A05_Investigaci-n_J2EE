/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author DSMan
 */
@Stateless
public class Sesiosn {
@PersistenceUnit
EntityManagerFactory emf;
public List findAll(){
 return
emf.createEntityManager().createNamedQuery
("Actores.findAll").getResultList();
}
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
