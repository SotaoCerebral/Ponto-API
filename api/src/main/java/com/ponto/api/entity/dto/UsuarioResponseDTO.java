package com.ponto.api.entity.dto;


import com.ponto.api.entity.usuario.Usuario;
import com.ponto.api.entity.enums.UserRole;

public record UsuarioResponseDTO(
        Long id,
        String email,
        UserRole role
) {
    public UsuarioResponseDTO(Usuario dados) {
        this(
                dados.getId(),
                dados.getEmail(),
                dados.getRole()
        );
    }
}
