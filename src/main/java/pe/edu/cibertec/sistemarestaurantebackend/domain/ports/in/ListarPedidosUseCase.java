package pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in;

import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Pedido;
import java.util.List;

public interface ListarPedidosUseCase {
    List<Pedido> ejecutar();
}