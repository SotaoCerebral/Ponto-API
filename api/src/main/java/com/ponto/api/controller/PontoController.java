package com.ponto.api.controller;

import com.ponto.api.entity.dto.PontoRequestDTO;
import com.ponto.api.entity.dto.PontoResponseDTO;
import com.ponto.api.entity.ponto.Ponto;
import com.ponto.api.service.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ponto")
public class PontoController {

    @Autowired
    private PontoService pontoService;


    @PostMapping
    private ResponseEntity<Ponto> registarPonto(@RequestBody PontoRequestDTO dto){
        return ResponseEntity.ok(pontoService.registrarPonto(dto));
    }
    @GetMapping
    private ResponseEntity<List<PontoResponseDTO>> listarPontos(@RequestParam(required = false) Long usuarioId){
        return ResponseEntity.ok(pontoService.listarPonto(usuarioId));
    }
    @GetMapping("/retorno")
    private ResponseEntity<List<Ponto>> listarPontosretorno(){
        return ResponseEntity.ok(pontoService.listarPontoRetorno());
    }
}
