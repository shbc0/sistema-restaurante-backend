package pe.edu.cibertec.sistemarestaurantebackend.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Usuario;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in.ObtenerUsuariosUseCase;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out.UsuarioRepositoryPort;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements ObtenerUsuariosUseCase {
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    @Override
    public List<Usuario> ejecutar() { return usuarioRepositoryPort.listarTodos(); }
}