package com.ponto.api.controller;

import com.ponto.api.entity.usuario.Usuario;
import com.ponto.api.entity.dto.DadosAutenticacao;
import com.ponto.api.entity.dto.UsuarioResponseDTO;
import com.ponto.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @PostMapping()
    public ResponseEntity<Usuario> criarUsuario(@RequestBody DadosAutenticacao dadosAutenticacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarUsuario(dadosAutenticacao));

    }
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
        return ResponseEntity.ok(service.listarUsuarios());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioResponseDTO>> listarUsuarios(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarUsuarioUnico(id));
    }

}
