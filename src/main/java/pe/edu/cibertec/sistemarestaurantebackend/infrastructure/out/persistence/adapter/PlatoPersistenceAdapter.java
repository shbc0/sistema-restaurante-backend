package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Plato;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out.PlatoRepositoryPort;
import pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.entity.PlatoEntity;
import pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.repository.SpringDataPlatoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PlatoPersistenceAdapter implements PlatoRepositoryPort {

    private final SpringDataPlatoRepository platoRepository;

    @Override
    public Plato guardar(Plato plato) {
        pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.entity.CategoriaEntity categoriaEntity = null;
        if (plato.getCategoria() != null) {
            categoriaEntity = new pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.entity.CategoriaEntity(
                    plato.getCategoria().getId(),
                    plato.getCategoria().getNombre()
            );
        }

        PlatoEntity entity = new PlatoEntity(
                plato.getId(),
                plato.getNombre(),
                plato.getDescripcion(),
                plato.getPrecio(),
                plato.getDisponible(),
                categoriaEntity
        );

        PlatoEntity entidadGuardada = platoRepository.save(entity);

        pe.edu.cibertec.sistemarestaurantebackend.domain.model.Categoria categoriaDominio = null;
        if (entidadGuardada.getCategoria() != null) {
            categoriaDominio = new pe.edu.cibertec.sistemarestaurantebackend.domain.model.Categoria(
                    entidadGuardada.getCategoria().getId(),
                    entidadGuardada.getCategoria().getNombre()
            );
        }

        return new Plato(
                entidadGuardada.getId(),
                entidadGuardada.getNombre(),
                entidadGuardada.getDescripcion(),
                entidadGuardada.getPrecio(),
                entidadGuardada.getDisponible(),
                categoriaDominio
        );
    }

    @Override
    public List<Plato> listarTodos() {
        return platoRepository.findAll().stream()
                .map(entity -> new Plato(
                        entity.getId(),
                        entity.getNombre(),
                        entity.getDescripcion(),
                        entity.getPrecio(),
                        entity.getDisponible(),
                        null
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Plato> buscarPorId(Long id) {
        return platoRepository.findById(id)
                .map(entity -> new Plato(
                        entity.getId(),
                        entity.getNombre(),
                        entity.getDescripcion(),
                        entity.getPrecio(),
                        entity.getDisponible(),
                        null
                ));
    }

    @Override
    public void eliminar(Long id) {
        platoRepository.deleteById(id);
    }
}