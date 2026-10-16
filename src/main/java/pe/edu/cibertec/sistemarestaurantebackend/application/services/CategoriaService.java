package pe.edu.cibertec.sistemarestaurantebackend.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Categoria;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in.ObtenerCategoriasUseCase;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out.CategoriaRepositoryPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService implements ObtenerCategoriasUseCase {

    private final CategoriaRepositoryPort categoriaRepositoryPort;

    @Override
    public List<Categoria> ejecutar() {
        return categoriaRepositoryPort.listarTodas();
    }
}