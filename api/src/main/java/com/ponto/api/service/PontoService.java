package com.ponto.api.service;

import com.ponto.api.entity.dto.PontoRequestDTO;
import com.ponto.api.entity.dto.PontoResponseDTO;
import com.ponto.api.entity.dto.UsuarioResponseDTO;
import com.ponto.api.entity.ponto.Ponto;
import com.ponto.api.entity.usuario.Usuario;
import com.ponto.api.repository.PontoRepository;
import com.ponto.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PontoService {

    @Autowired
    private PontoRepository pontoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Ponto registrarPonto(PontoRequestDTO dto) {
        Usuario usuario = usuarioRepository.getReferenceById(dto.UsuarioId());
        Ponto ponto = new Ponto(dto.descricao(), usuario, dto.entradas());
        return pontoRepository.save(ponto);
    }

    public List<PontoResponseDTO> listarPonto(Long usuarioId) {

        if (usuarioId != null) {
            return pontoRepository.findByUsuarioId(usuarioId).stream().map(PontoResponseDTO::new).collect(Collectors.toList());
        }
        return pontoRepository.findAll()
                .stream()
                .map(PontoResponseDTO::new)
                .collect(Collectors.toList());
    }

    public List<Ponto> listarPontoRetorno() {

        return pontoRepository.findAll();
    }
}
