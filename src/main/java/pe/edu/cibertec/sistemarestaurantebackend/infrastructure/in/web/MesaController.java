package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Mesa;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in.ObtenerMesasUseCase;
import java.util.List;

@RestController
@RequestMapping("/api/mesas")
@RequiredArgsConstructor
public class MesaController {
    private final ObtenerMesasUseCase obtenerMesasUseCase;

    @GetMapping
    public ResponseEntity<List<Mesa>> listarMesas() {
        return ResponseEntity.ok(obtenerMesasUseCase.ejecutar());
    }
}