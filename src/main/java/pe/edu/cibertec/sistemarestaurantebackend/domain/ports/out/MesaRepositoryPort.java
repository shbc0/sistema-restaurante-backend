package pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out;

import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Mesa;
import java.util.List;

public interface MesaRepositoryPort {
    List<Mesa> listarTodas();
}