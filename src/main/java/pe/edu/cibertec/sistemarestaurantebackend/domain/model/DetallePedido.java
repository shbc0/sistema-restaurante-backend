package pe.edu.cibertec.sistemarestaurantebackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedido {
    private Long id;
    private Plato plato;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
}