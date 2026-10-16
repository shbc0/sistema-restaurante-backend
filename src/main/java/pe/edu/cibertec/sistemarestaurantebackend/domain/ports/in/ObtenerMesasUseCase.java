package pe.edu.cibertec.sistemarestaurantebackend.domain.ports.in;
import pe.edu.cibertec.sistemarestaurantebackend.domain.model.Mesa;
import java.util.List;
public interface ObtenerMesasUseCase { List<Mesa> ejecutar(); }