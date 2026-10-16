package pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in;

import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Categoria;
import java.util.List;

public interface ObtenerCategoriasUseCase {
    List<Categoria> ejecutar();
}