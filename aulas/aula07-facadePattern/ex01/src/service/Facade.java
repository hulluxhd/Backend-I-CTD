package service;

import model.Cartao;
import model.Produto;

public interface Facade {

    public int calcularDesconto(Cartao cartao, Produto produto, int quantidade);

}
