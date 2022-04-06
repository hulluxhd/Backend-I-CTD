package service;

import model.Viagem;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ApiHotel implements IFacade{
    @Override
    public String buscar(Viagem cidade) {
        List<String> hoteis = Arrays.asList("Hotel 1", "Hotel 2", "Hotel 3");

        Random r = new Random();

        return hoteis.get(r.nextInt(hoteis.size()));



    }
}
