package pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out;

import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Categoria;
import java.util.List;

public interface CategoriaRepositoryPort {
    List<Categoria> listarTodas();
}