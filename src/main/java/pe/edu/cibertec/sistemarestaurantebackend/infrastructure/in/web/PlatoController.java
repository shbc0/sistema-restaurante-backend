package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sistemarestaurantebackend.application.services.PlatoService;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Plato;

import java.util.List;

@RestController
@RequestMapping("/api/platos")
public class PlatoController {

    private final PlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping
    public ResponseEntity<List<Plato>> listarPlatos() {
        return ResponseEntity.ok(platoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plato> obtenerPlato(@PathVariable Long id) {
        return platoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Plato> crearPlato(@RequestBody Plato plato) {
        return ResponseEntity.ok(platoService.guardar(plato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plato> actualizarPlato(@PathVariable Long id, @RequestBody Plato plato) {
        return platoService.buscarPorId(id)
                .map(platoExistente -> {
                    plato.setId(id);
                    return ResponseEntity.ok(platoService.guardar(plato));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPlato(@PathVariable Long id) {
        platoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}