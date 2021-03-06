/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Modelo.Peliculas;
import java.util.Date;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Guillermo Crespo, Javier Borreguero y Miguel Martinez
 */
@Stateless
public class Session {
@PersistenceUnit
EntityManagerFactory emf;
public List allPeliculas(){
 return emf.createEntityManager().createNamedQuery("Peliculas.findAll").getResultList();
}
 public List buscarAllPecliculasporTitulo(String tittle) {
     
         return emf.createEntityManager().createNamedQuery("Peliculas.findByTitulo").setParameter("titulo", tittle).getResultList();
    }
    
    public List allRepartos() {
        return emf.createEntityManager().createNamedQuery("Reparto.findAll").getResultList();
    }
    public void nuevaPelicula(Peliculas pelicula) {
        emf.createEntityManager().persist(pelicula);
    }
    
    public void borrarPelicula(String titulo) {

       Peliculas pelicula;
        EntityManager em = emf.createEntityManager();
        pelicula = em.find(Peliculas.class, titulo);
        em.remove(pelicula);
        
    }

    public void updatePelicula(int id, String name, Date date, Double presupuesto) {
        Peliculas pelicula;
        EntityManager em = emf.createEntityManager();
        pelicula = em.find(Peliculas.class, id);
        pelicula.setCodigo(id);
        pelicula.setFecha(date);
        pelicula.setPresupuesto(presupuesto);
        pelicula.setTitulo(name);
        em.merge(pelicula);
        
    }
    public void updatePelicula(Peliculas pelicula) {
        EntityManager em = emf.createEntityManager();
        em.merge(pelicula);
        
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
