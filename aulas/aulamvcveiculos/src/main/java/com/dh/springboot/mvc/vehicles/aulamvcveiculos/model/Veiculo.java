package com.dh.springboot.mvc.vehicles.aulamvcveiculos.model;

public class Veiculo {
    private String marca, cor;

    public Veiculo(String marca, String cor) {
        this.marca = marca;
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}