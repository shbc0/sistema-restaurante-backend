package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.entity.UsuarioEntity;

import java.util.Optional;

@Repository
public interface SpringDataUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByUsername(String username);
}