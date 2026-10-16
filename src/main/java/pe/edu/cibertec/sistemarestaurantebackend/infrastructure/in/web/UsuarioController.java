package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Usuario;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in.ObtenerUsuariosUseCase;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final ObtenerUsuariosUseCase obtenerUsuariosUseCase;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(obtenerUsuariosUseCase.ejecutar());
    }
}