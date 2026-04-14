package exp2.s4.peliculas.controladores;

import exp2.s4.peliculas.dto.PeliculaDTO;
import exp2.s4.peliculas.servicios.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import exp2.s4.peliculas.dto.PeliculaRequest;


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

    // ===================== POST =====================
 
    // POST: http://localhost:8080/peliculas
    // Body JSON: { "titulo": "...", "anno": 2000, "idDirector": 1, "idGenero": 2, "sinopsis": "..." }
    @PostMapping
    public ResponseEntity<?> crearPelicula(@RequestBody PeliculaRequest req) {
        PeliculaDTO creada = service.crear(req);
        if (creada == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                    "timestamp", LocalDateTime.now().toString(),
                    "status", 400,
                    "errores", Map.of("referencia", "El idDirector o idGenero indicado no existe en la base de datos.")
                )
            );
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

// ===================== PUT =====================
 
    // PUT: http://localhost:8080/peliculas/1
    // Body JSON: { "titulo": "...", "anno": 2000, "idDirector": 1, "idGenero": 2, "sinopsis": "..." }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarPelicula(@PathVariable int id, @RequestBody PeliculaRequest req) {
        PeliculaDTO modificada = service.modificar(id, req);
        if (modificada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                    "timestamp", LocalDateTime.now().toString(),
                    "status", 404,
                    "errores", Map.of("id", "No se encontró una película con ese ID, o el idDirector/idGenero no existe.")
                )
            );
        }
        return ResponseEntity.ok(modificada);
    }

    // ===================== DELETE =====================
 
    // DELETE: http://localhost:8080/peliculas/1
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPelicula(@PathVariable int id) {
        boolean eliminada = service.eliminar(id);
        if (!eliminada) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                    "timestamp", LocalDateTime.now().toString(),
                    "status", 404,
                    "errores", Map.of("id", "No se encontró una película con ese ID.")
                )
            );
        }
        return ResponseEntity.ok(
            Map.of(
                "timestamp", LocalDateTime.now().toString(),
                "status", 200,
                "mensaje", "Película con ID " + id + " eliminada correctamente."
            )
        );
    }


}