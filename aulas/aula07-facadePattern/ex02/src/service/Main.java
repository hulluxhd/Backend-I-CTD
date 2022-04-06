package service;

import model.Viagem;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Viagem v1 = new Viagem("1", "2", "Fortaleza", "SP");
        controlador.buscar(v1);
    }
}
