package service.impl;

import model.Produto;

public class ApiProduto {


    public int desconto(Produto produto){
        if (produto.getTipo().equalsIgnoreCase("Lata")){
            return 10;
        } else return 0;
    }


}
