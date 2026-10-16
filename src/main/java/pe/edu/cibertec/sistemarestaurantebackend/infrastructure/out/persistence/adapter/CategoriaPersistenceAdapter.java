package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Categoria;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out.CategoriaRepositoryPort;
import pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.repository.SpringDataCategoriaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoriaPersistenceAdapter implements CategoriaRepositoryPort {

    private final SpringDataCategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll().stream()
                .map(entity -> new Categoria(entity.getId(), entity.getNombre()))
                .collect(Collectors.toList());
    }
}