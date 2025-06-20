package com.ponto.api.entity.dto;

import com.ponto.api.entity.enums.Entradas;

public record PontoRequestDTO(String descricao, Long UsuarioId, Entradas entradas) {
}
