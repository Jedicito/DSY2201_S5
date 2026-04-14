package exp2.s4.peliculas.repositorios;


import exp2.s4.peliculas.modelos.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    // JpaRepository tiene findAll() y findById(). ¿Paq esto toncs?
}