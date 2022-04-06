package com.dh.aula14.aulainiciospringboot.model;

public class Endereco {
    private int id;
    private String rua;
    private int numero;
    private String cidade;
    private String bairro;
    private String estado;

// criando todas as possibilidades de construtores


    public Endereco(int id, String rua, int numero, String cidade, String bairro, String estado) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
    }

    public Endereco(String rua, int numero, String cidade, String bairro, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
    }

    public Endereco() {
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", numero=" + numero +
                ", rua='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

