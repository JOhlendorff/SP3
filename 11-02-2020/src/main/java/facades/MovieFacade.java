package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");      
    MovieFacade facade = MovieFacade.getMovieFacade(emf);
    Movie m1 = facade.addMovie(new Movie("Lars Von Trier", "Melancholia", "Kirsten Dunst"));
    //Find book by ID

    }
    
    //Private Constructor to ensure Singleton
    private MovieFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getMovieCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM Movie r").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }
    
    public List<Movie> getMovieByTitle(String MovieTitle){
        EntityManager em = emf.createEntityManager();
        
        try{
            TypedQuery<Movie> query = 
                       em.createQuery("Select c from Movie c where c.MovieTitle = :MovieTitle",Movie.class);
            query.setParameter("MovieTitle", MovieTitle);
            return query.getResultList();
        }finally {
            em.close();
        }
    
        
    }
    
    public Movie addMovie(Movie m){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
            return m;
        }finally {
            em.close();
        }
    }
    

}
