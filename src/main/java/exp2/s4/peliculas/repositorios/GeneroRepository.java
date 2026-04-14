package exp2.s4.peliculas.repositorios;

import exp2.s4.peliculas.modelos.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}