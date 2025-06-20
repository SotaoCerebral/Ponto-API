package com.ponto.api.entity.dto;


import com.ponto.api.entity.enums.UserRole;

public record DadosAutenticacao(

        String email,
        String senha,
        UserRole role
) {
}
