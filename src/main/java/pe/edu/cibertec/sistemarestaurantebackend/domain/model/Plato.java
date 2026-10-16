package pe.edu.cibertec.sistemarestaurantebackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plato {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Boolean disponible;
    private Categoria categoria;
}