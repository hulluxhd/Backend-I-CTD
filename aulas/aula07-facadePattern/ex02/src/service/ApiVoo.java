package service;

import model.Viagem;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ApiVoo implements IFacade{

    @Override
    public String buscar(Viagem cidade) {
        List<String> linhasAereas = Arrays.asList("Gol", "Tam", "Azul");

        Random r = new Random();

        return linhasAereas.get(r.nextInt(linhasAereas.size()));

    }
}
