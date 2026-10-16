package pe.edu.cibertec.sistemarestaurantebackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {
    private Long id;
    private Integer numero;
    private Integer capacidad;
    private String estado;
}