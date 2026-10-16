package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.entity.PlatoEntity;

public interface SpringDataPlatoRepository extends JpaRepository<PlatoEntity, Long> {
}