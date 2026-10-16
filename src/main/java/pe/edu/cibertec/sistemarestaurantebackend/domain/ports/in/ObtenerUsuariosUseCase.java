package pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Usuario;
import java.util.List;
public interface ObtenerUsuariosUseCase { List<Usuario> ejecutar(); }