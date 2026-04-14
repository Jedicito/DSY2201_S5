package exp2.s4.peliculas.repositorios;

import exp2.s4.peliculas.modelos.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}