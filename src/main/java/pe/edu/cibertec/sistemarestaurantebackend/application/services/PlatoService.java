package pe.edu.cibertec.sistemarestaurantebackend.application.services;

import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Plato;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out.PlatoRepositoryPort;

import java.util.List;
import java.util.Optional;

public class PlatoService {

    private final PlatoRepositoryPort platoRepositoryPort;

    public PlatoService(PlatoRepositoryPort platoRepositoryPort) {
        this.platoRepositoryPort = platoRepositoryPort;
    }

    public List<Plato> listarTodos() {
        return platoRepositoryPort.listarTodos();
    }

    public Optional<Plato> buscarPorId(Long id) {
        return platoRepositoryPort.buscarPorId(id);
    }

    public Plato guardar(Plato plato) {
        return platoRepositoryPort.guardar(plato);
    }

    public void eliminar(Long id) {
        platoRepositoryPort.eliminar(id);
    }
}