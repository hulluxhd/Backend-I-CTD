package com.dh.springboot.mvc.vehicles.aulamvcveiculos.controller;

import com.dh.springboot.mvc.vehicles.aulamvcveiculos.model.Veiculo;
import com.dh.springboot.mvc.vehicles.aulamvcveiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/listaveiculos")
public class VeiculoController {

    private VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }



    @GetMapping
    public List<Veiculo> listando(){
        return veiculoService.veiculoList();
    }
}
