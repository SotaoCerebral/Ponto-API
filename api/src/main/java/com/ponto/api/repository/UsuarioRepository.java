package com.ponto.api.repository;


import com.ponto.api.entity.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByEmail(String username);

    Usuario findByEmailIgnoreCase(String email);

}
