package service.series;

import model.SerieServiceInterface;

public class SerieServiceProxy implements SerieServiceInterface {
    @Override
    public void getSerie(Serie nome) {
        if (nome.getQtdViews() <= 5){
            SerieServiceInterface serie = new SerieService();
            serie.getSerie(nome);
        } else System.out.println("Excede o número de repetições permitidas!");
    }
}
