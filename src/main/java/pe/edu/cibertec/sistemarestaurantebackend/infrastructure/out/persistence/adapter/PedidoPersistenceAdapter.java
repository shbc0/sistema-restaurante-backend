package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Pedido;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out.PedidoRepositoryPort;
import pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.entity.*;
import pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.repository.SpringDataPedidoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PedidoPersistenceAdapter implements PedidoRepositoryPort {

    private final SpringDataPedidoRepository pedidoRepository;

    @Override
    public Pedido guardar(Pedido pedido) {
        MesaEntity mesaEntity = new MesaEntity();
        mesaEntity.setId(pedido.getMesa().getId());

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(pedido.getUsuario().getId());

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setMesa(mesaEntity);
        pedidoEntity.setUsuario(usuarioEntity);
        pedidoEntity.setEstado(pedido.getEstado());
        pedidoEntity.setTotal(pedido.getTotal());
        pedidoEntity.setFechaCreacion(pedido.getFechaCreacion());

        List<DetallePedidoEntity> detallesEntity = pedido.getDetalles().stream().map(detalle -> {
            PlatoEntity platoEntity = new PlatoEntity();
            platoEntity.setId(detalle.getPlato().getId());

            DetallePedidoEntity detEntity = new DetallePedidoEntity();
            detEntity.setPedido(pedidoEntity);
            detEntity.setPlato(platoEntity);
            detEntity.setCantidad(detalle.getCantidad());
            detEntity.setPrecioUnitario(detalle.getPrecioUnitario());
            detEntity.setSubtotal(detalle.getSubtotal());
            return detEntity;
        }).collect(Collectors.toList());

        pedidoEntity.setDetalles(detallesEntity);

        PedidoEntity pedidoGuardado = pedidoRepository.save(pedidoEntity);

        pedido.setId(pedidoGuardado.getId());
        return pedido;
    }

    @Override
    public List<Pedido> listarTodos() {
        return List.of();
    }
}