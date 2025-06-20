package com.ponto.api.repository;

import com.ponto.api.entity.ponto.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PontoRepository extends JpaRepository<Ponto, Long> {

    List<Ponto> findByUsuarioId(Long usuarioId);
}
