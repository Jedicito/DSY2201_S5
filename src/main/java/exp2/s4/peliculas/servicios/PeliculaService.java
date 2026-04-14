package exp2.s4.peliculas.servicios;


import exp2.s4.peliculas.dto.PeliculaDTO;
import exp2.s4.peliculas.modelos.Director;
import exp2.s4.peliculas.modelos.Genero;
import exp2.s4.peliculas.modelos.Pelicula;
import exp2.s4.peliculas.repositorios.PeliculaRepository;
import org.springframework.stereotype.Service;
import exp2.s4.peliculas.repositorios.DirectorRepository;
import exp2.s4.peliculas.repositorios.GeneroRepository;
import exp2.s4.peliculas.dto.PeliculaRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeliculaService {

        private final PeliculaRepository peliculaRepository;
    private final DirectorRepository directorRepository;
    private final GeneroRepository   generoRepository;
 
    public PeliculaService(PeliculaRepository peliculaRepository,
                           DirectorRepository directorRepository,
                           GeneroRepository generoRepository) {
        this.peliculaRepository = peliculaRepository;
        this.directorRepository = directorRepository;
        this.generoRepository   = generoRepository;
    }

        // --- Listar todas ---
    public List<PeliculaDTO> listarPeliculas() {
        return peliculaRepository.findAll()
                .stream()
                .map(PeliculaDTO::new)
                .collect(Collectors.toList());
    }
 
    // --- Buscar por ID ---
    public PeliculaDTO buscarPorId(int id) {
        Optional<Pelicula> resultado = peliculaRepository.findById(id);
        return resultado.map(PeliculaDTO::new).orElse(null);
    }

        // --- Crear ---
    public PeliculaDTO crear(PeliculaRequest req) {
        Optional<Director> director = directorRepository.findById(req.getIdDirector());
        Optional<Genero>   genero   = generoRepository.findById(req.getIdGenero());
 
        if (director.isEmpty() || genero.isEmpty()) {
            return null;
        }
 
        Pelicula nueva = new Pelicula();
        nueva.setTitulo(req.getTitulo());
        nueva.setAnno(req.getAnno());
        nueva.setDirector(director.get());
        nueva.setGenero(genero.get());
        nueva.setSinopsis(req.getSinopsis());
 
        Pelicula guardada = peliculaRepository.save(nueva);
        return new PeliculaDTO(guardada);
    }

        // --- Modificar ---
    public PeliculaDTO modificar(int id, PeliculaRequest req) {
        Optional<Pelicula> resultado = peliculaRepository.findById(id);
        if (resultado.isEmpty()) {
            return null;
        }
 
        Optional<Director> director = directorRepository.findById(req.getIdDirector());
        Optional<Genero>   genero   = generoRepository.findById(req.getIdGenero());
        if (director.isEmpty() || genero.isEmpty()) {
            return null;
        }
 
        Pelicula pelicula = resultado.get();
        pelicula.setTitulo(req.getTitulo());
        pelicula.setAnno(req.getAnno());
        pelicula.setDirector(director.get());
        pelicula.setGenero(genero.get());
        pelicula.setSinopsis(req.getSinopsis());
 
        Pelicula actualizada = peliculaRepository.save(pelicula);
        return new PeliculaDTO(actualizada);
    }
}