package com.dh.springboot.mvc.vehicles.aulamvcveiculos.service;

import com.dh.springboot.mvc.vehicles.aulamvcveiculos.model.Veiculo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService  {
    @Override
    public List<Veiculo> veiculoList() {
        return Arrays.asList(
                new Veiculo("Sei la", "Azul"),
                new Veiculo("Sei la mesmo", "Amarelo"),
                new Veiculo("Nem gosto de carro", "Vermelho")
        );
    }
}
