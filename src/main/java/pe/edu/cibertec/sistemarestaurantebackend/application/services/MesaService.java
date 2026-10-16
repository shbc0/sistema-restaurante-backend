package pe.edu.cibertec.sistemarestaurantebackend.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Mesa;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in.ObtenerMesasUseCase;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out.MesaRepositoryPort;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MesaService implements ObtenerMesasUseCase {
    private final MesaRepositoryPort mesaRepositoryPort;
    @Override
    public List<Mesa> ejecutar() { return mesaRepositoryPort.listarTodas(); }
}