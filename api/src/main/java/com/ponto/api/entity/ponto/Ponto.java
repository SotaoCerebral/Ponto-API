package com.ponto.api.entity.ponto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ponto.api.entity.dto.PontoRequestDTO;
import com.ponto.api.entity.enums.Entradas;
import com.ponto.api.entity.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "pontos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ponto {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime horario = LocalDateTime.now();
    private String descricao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    private Entradas entradas;


    public Ponto(String descricao, Usuario usuario, Entradas entradas) {
        this.descricao = descricao;
        this.usuario = usuario;
        this.entradas = entradas;
    }
}
