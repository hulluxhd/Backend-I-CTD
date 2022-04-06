package com.hibernate.time.exerciciotime.controller;

import com.hibernate.time.exerciciotime.model.Jogador;
import com.hibernate.time.exerciciotime.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private JogadorService jogadorService;

    @Autowired
    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Jogador jogador){
        jogadorService.salvar(jogador);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
