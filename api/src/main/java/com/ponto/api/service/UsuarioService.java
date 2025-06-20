package com.ponto.api.service;

import com.ponto.api.entity.usuario.Usuario;
import com.ponto.api.entity.dto.DadosAutenticacao;
import com.ponto.api.entity.dto.UsuarioResponseDTO;
import com.ponto.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;



    public Usuario criarUsuario(DadosAutenticacao dadosAutenticacao) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Usuario usuario = new Usuario(dadosAutenticacao);
        usuario.setSenha(encoder.encode(usuario.getPassword()));
        return repository.save(usuario);
    }


    public List<UsuarioResponseDTO> listarUsuarios() {
        return repository.findAll()
                .stream()
                .map(UsuarioResponseDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioResponseDTO> listarUsuarioUnico(Long id) {
        return repository.findById(id)
                .map(UsuarioResponseDTO::new);

    }


}
