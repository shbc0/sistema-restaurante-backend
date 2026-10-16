package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.entity.CategoriaEntity;

@Repository
public interface SpringDataCategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}