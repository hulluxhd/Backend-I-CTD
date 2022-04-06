package service.impl;

import model.Cartao;

public class ApiCartao {

    public int desconto(Cartao cartao){
        if (cartao.getBanco().compareToIgnoreCase("Star Bank") == 0){
            return 20;
        } else  return 0;
    }

}
