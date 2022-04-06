import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    @Test
    void Teste(){
        Cardapio c1 = new Adulto(25, 2, 2);
        c1.calcularPreco();

        Cardapio c2 = new Infantil(22.44, 2.2, 1, 5.5);
        c2.calcularPreco();

        Cardapio c3 = new Vegetariano(28, 2.3, 1, 1.77);
        c3.calcularPreco();

    }

}