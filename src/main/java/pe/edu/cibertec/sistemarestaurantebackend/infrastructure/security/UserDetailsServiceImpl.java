package pe.edu.cibertec.sistemarestaurantebackend.infrastructure.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.entity.UsuarioEntity;
import pe.edu.cibertec.sistemarestaurantebackend.infrastructure.out.persistence.repository.SpringDataUsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SpringDataUsuarioRepository repository;

    public UserDetailsServiceImpl(SpringDataUsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado en la Base de Datos"));

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRol())
                .build();
    }
}