package com.hibernate.time.exerciciotime.service;

import com.hibernate.time.exerciciotime.model.Jogador;
import com.hibernate.time.exerciciotime.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorService {
    private JogadorRepository jogadorRepository;
    @Autowired
    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public void salvar(Jogador jogador){
        jogadorRepository.save(jogador);
    }
}
