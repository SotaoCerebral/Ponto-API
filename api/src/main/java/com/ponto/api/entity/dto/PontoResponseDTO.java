package com.ponto.api.entity.dto;

import com.ponto.api.entity.enums.Entradas;
import com.ponto.api.entity.ponto.Ponto;


import java.time.LocalDateTime;

public record PontoResponseDTO(Long id, String email, String descricao, Entradas entradas, LocalDateTime horario) {

    public PontoResponseDTO(Ponto dados) {
        this(
                dados.getId(),
                dados.getUsuario().getEmail(),
                dados.getDescricao(),
                dados.getEntradas(),
                dados.getHorario()
        );
    }
}
