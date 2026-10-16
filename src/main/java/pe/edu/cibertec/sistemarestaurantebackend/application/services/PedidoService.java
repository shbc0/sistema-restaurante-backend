package pe.edu.cibertec.sistemarestaurantebackend.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Pedido;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in.CrearPedidoUseCase;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in.ListarPedidosUseCase;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out.PedidoRepositoryPort;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService implements CrearPedidoUseCase, ListarPedidosUseCase {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    @Override
    public Pedido ejecutar(Pedido pedido) {
        pedido.setFechaCreacion(LocalDateTime.now());
        pedido.setEstado("PENDIENTE");

        double totalPedido = 0.0;
        if (pedido.getDetalles() != null) {
            for (var detalle : pedido.getDetalles()) {
                double subtotal = detalle.getCantidad() * detalle.getPrecioUnitario();
                detalle.setSubtotal(subtotal);
                totalPedido += subtotal;
            }
        }
        pedido.setTotal(totalPedido);

        return pedidoRepositoryPort.guardar(pedido);
    }

    @Override
    public List<Pedido> ejecutar() {
        return pedidoRepositoryPort.listarTodos();
    }
}