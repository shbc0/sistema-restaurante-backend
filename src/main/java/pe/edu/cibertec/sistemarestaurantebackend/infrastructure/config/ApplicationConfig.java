package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.edu.cibertec.sistemarestaurantebackend.application.services.PlatoService;
import pe.edu.cibertec.sistemarestaurantebackend.application.services.UsuarioService;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out.PlatoRepositoryPort;
import pe.edu.cibertec.sistemarestaurantebackend.domain.ports.out.UsuarioRepositoryPort;

@Configuration
public class ApplicationConfig {

    @Bean
    public UsuarioService usuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        return new UsuarioService(usuarioRepositoryPort);
    }

    @Bean
    public PlatoService platoService(PlatoRepositoryPort platoRepositoryPort) {
        return new PlatoService(platoRepositoryPort);
    }
}