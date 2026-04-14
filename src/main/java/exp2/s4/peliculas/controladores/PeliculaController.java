package exp2.s4.peliculas.controladores;

import exp2.s4.peliculas.dto.PeliculaDTO;
import exp2.s4.peliculas.servicios.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService service;

    public PeliculaController(PeliculaService service) {
        this.service = service;
    }

    // GET: http://localhost:8080/peliculas
    @GetMapping
    public List<PeliculaDTO> listarPeliculas() {
        return service.listarPeliculas();
    }

    // GET: http://localhost:8080/peliculas/1
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        PeliculaDTO pelicula = service.buscarPorId(id);
        if (pelicula == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                    "timestamp", LocalDateTime.now(),
                    "status", 404,
                    "errores", Map.of("id", "No se encontró una película con ese ID.")
                )
            );
        }
        return ResponseEntity.ok(pelicula);
    }
}