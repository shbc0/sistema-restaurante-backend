package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Usuario;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out.UsuarioRepositoryPort;
import pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.repository.SpringDataUsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsuarioPersistenceAdapter implements UsuarioRepositoryPort {

    private final SpringDataUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(entity -> new Usuario(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getRol()))
                .collect(Collectors.toList());
    }
}