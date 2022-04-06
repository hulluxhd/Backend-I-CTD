package service;

import model.Triangulo;

import java.util.HashMap;

public class FiguraFactory {
    private HashMap listaFiguras;

    public FiguraFactory() {
        this.listaFiguras = new HashMap<String, Figura>();
    }

    public void criar(Figura figura){


        if (!(listaFiguras.containsKey(figura.getCor()) || listaFiguras.containsKey(figura.getTamanho()))) {
            listaFiguras.put(figura.getTamanho(), figura);
            System.out.println("Criado: " + figura.getClass());
        } else {
            System.out.println("Já há uma instância em memória");
        }


    }

    public HashMap getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(HashMap listaFiguras) {
        this.listaFiguras = listaFiguras;
    }

    @Override
    public String toString() {
        return "FiguraFactory{" +
                "listaFiguras=" + listaFiguras +
                '}';
    }
}
