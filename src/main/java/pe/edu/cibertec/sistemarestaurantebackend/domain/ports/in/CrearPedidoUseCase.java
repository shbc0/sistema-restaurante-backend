package pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in;

import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Pedido;

public interface CrearPedidoUseCase {
    Pedido ejecutar(Pedido pedido);
}