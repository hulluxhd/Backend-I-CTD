package com.dh.springboot.mvc.aulamvc.controller;

import com.dh.springboot.mvc.aulamvc.model.Trainer;
import com.dh.springboot.mvc.aulamvc.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // sinaliza que é um controlador que fica aguardando uma requisição
@RequestMapping("/trainer") // gera um mapeamento da url (quando cair aqui, faz o quê?, direciona pra onde? chama
// qual método?
public class TrainerController {
    // quando cair em /trainer, instancia a interface TrainerService e chama o método de listar, lá embaixo

    private TrainerService trainerService;

    @Autowired //automatiza a criação do construtor?
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping // é o que vai retornar
    public List<Trainer> buscarTodos(){
        return trainerService.listTrainer();
    }


}
