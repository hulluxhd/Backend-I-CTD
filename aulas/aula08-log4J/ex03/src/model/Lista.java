package model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    private static final Logger logger = Logger.getLogger(Lista.class);
    List<Integer> listaInteiros = new ArrayList<>();

    public void addNumero(int numero){
        listaInteiros.add(numero);
        if (listaInteiros.size() > 10){
            logger.info("A lista tem mais de 10 itens!");
        } else if (listaInteiros.size() > 5){
            logger.info("A lista tem mais de 5 itens!");
        }
    }

    public double calculaMedia() throws Exception{
        int soma = 0;
        for (int x: listaInteiros) {
            soma += x;
        }
        double media = soma/listaInteiros.size();
        logger.info("A média é de " + media);
        if (media < 0){
            logger.error("A média não pode ser negativa");
            throw new Exception();

    }
        return media;

    }



}
