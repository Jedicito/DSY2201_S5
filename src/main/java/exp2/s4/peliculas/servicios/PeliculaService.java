package exp2.s4.peliculas.servicios;


import exp2.s4.peliculas.dto.PeliculaDTO;
import exp2.s4.peliculas.modelos.Pelicula;
import exp2.s4.peliculas.repositorios.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeliculaService {

    private final PeliculaRepository repository;

    public PeliculaService(PeliculaRepository repository) {
        this.repository = repository;
    }

    public List<PeliculaDTO> listarPeliculas() {
        return repository.findAll()
                .stream()
                .map(PeliculaDTO::new)
                .collect(Collectors.toList());
    }

    public PeliculaDTO buscarPorId(int id) {
        Optional<Pelicula> resultado = repository.findById(id);
        return resultado.map(PeliculaDTO::new).orElse(null);
    }
}