package pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out;

import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Pedido;
import java.util.List;

public interface PedidoRepositoryPort {
    Pedido guardar(Pedido pedido);
    List<Pedido> listarTodos();
}