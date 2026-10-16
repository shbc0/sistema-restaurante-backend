package pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out;

import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Plato;
import java.util.List;
import java.util.Optional;

public interface PlatoRepositoryPort {
    List<Plato> listarTodos();
    Optional<Plato> buscarPorId(Long id);
    Plato guardar(Plato plato);
    void eliminar(Long id);
}