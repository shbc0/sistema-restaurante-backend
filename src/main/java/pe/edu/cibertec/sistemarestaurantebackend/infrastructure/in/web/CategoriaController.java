package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Categoria;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in.ObtenerCategoriasUseCase;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final ObtenerCategoriasUseCase obtenerCategoriasUseCase;

    @GetMapping
    public List<Categoria> listarCategorias() {
        return obtenerCategoriasUseCase.ejecutar();
    }
}