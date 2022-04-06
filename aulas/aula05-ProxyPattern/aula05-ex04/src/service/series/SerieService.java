package service.series;

import model.SerieServiceInterface;

public class SerieService implements SerieServiceInterface {
    @Override
    public void getSerie(Serie nome) {
        nome.contador();
        System.out.println("O link para assistir é: " + nome.getLink());
    }
}
