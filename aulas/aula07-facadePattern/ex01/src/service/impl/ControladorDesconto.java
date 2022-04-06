package service.impl;

import model.Cartao;
import model.Produto;
import service.Facade;

public class ControladorDesconto implements Facade {

    ApiCartao apiCartao;
    ApiProduto apiProduto;
    ApiQuantidade apiQuantidade;


    public ControladorDesconto() {
        this.apiCartao = new ApiCartao();
        this.apiProduto = new ApiProduto();
        this.apiQuantidade = new ApiQuantidade();
    }


    @Override
    public int calcularDesconto(Cartao cartao, Produto produto, int quantidade) {
        int desconto = 0;
        desconto += apiCartao.desconto(cartao);
        desconto += apiProduto.desconto(produto);
        desconto += apiQuantidade.desconto(quantidade);
        System.out.println("O desconto total é de "+desconto+"%.");
        return desconto;
    }
}
