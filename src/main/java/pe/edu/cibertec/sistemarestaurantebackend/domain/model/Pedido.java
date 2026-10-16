package pe.edu.cibertec.sistemarestaurantebackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private Long id;
    private Mesa mesa;
    private Usuario usuario;
    private String estado;
    private Double total;
    private LocalDateTime fechaCreacion;
    private List<DetallePedido> detalles;
}