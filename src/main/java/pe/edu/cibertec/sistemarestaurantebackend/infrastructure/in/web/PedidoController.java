package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Pedido;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in.CrearPedidoUseCase;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in.ListarPedidosUseCase;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final CrearPedidoUseCase crearPedidoUseCase;
    private final ListarPedidosUseCase listarPedidosUseCase;

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = crearPedidoUseCase.ejecutar(pedido);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(listarPedidosUseCase.ejecutar());
    }
}