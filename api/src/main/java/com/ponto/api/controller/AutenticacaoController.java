package com.ponto.api.controller;

import com.ponto.api.entity.usuario.Usuario;
import com.ponto.api.entity.dto.DadosAutenticacao;
import com.ponto.api.entity.dto.UsuarioResponseDTO;
import com.ponto.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> efetuarLogin(@RequestBody @Validated DadosAutenticacao dados){
        Usuario usuario = repository.findByEmailIgnoreCase(dados.email());
        var token = new UsernamePasswordAuthenticationToken(dados.email(),dados.senha());
        var authentication =  manager.authenticate(token);

        return ResponseEntity.ok(new UsuarioResponseDTO(usuario));
    }
}
