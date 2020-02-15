package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
@NamedQuery(name = "Movie.deleteAllRows", query = "DELETE from Movie"),
@NamedQuery(name = "Movie.getAll", query = "SELECT m from Movie m"),
@NamedQuery(name = "Movie.getByMovieTitle", query = "SELECT m FROM Movie m WHERE m.MovieTitle LIKE :movieTitle")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String director;
    private String movieTitle;
    private String starringActor;
    
    public Movie() {
    }
        
    public Long getId() {
        return id;
    }

    public Movie(String director, String movieTitle, String starringActor) {
        this.director = director;
        this.movieTitle = movieTitle;
        this.starringActor = starringActor;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    // TODO, delete this class, or rename to an Entity class that makes sense for what you are about to do
    // Delete EVERYTHING below if you decide to use this class, it's dummy data used for the initial demo

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getStarringActor() {
        return starringActor;
    }

    public void setStarringActor(String starringActor) {
        this.starringActor = starringActor;
    }

    

   
}
