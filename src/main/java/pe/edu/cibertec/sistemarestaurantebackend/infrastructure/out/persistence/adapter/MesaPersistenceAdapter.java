package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Mesa;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out.MesaRepositoryPort;
import pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.repository.SpringDataMesaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MesaPersistenceAdapter implements MesaRepositoryPort {

    private final SpringDataMesaRepository mesaRepository;

    @Override
    public List<Mesa> listarTodas() {
        return mesaRepository.findAll().stream()
                .map(entity -> new Mesa(entity.getId(), entity.getNumero(), entity.getCapacidad(), entity.getEstado()))
                .collect(Collectors.toList());
    }
}