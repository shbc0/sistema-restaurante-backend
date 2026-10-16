package pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out;

import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Usuario;
import java.util.List;

public interface UsuarioRepositoryPort {
    List<Usuario> listarTodos();
}