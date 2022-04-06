package service;

import model.Quadrado;
import model.Triangulo;

public class Main {
    public static void main(String[] args) {
        FiguraFactory figuraFactory = new FiguraFactory();

        figuraFactory.criar(new Triangulo(2, "Verde"));
        figuraFactory.criar(new Triangulo(2, "Azul"));
        figuraFactory.criar(new Quadrado(3, "Azul"));
        System.out.println(figuraFactory.getListaFiguras().get(2));
    }
}
