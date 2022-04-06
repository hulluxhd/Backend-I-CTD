import model.Cartao;
import model.Produto;
import service.Facade;
import service.impl.ControladorDesconto;

public class Main {

    public static void main(String[] args) {
        Produto p1 = new Produto("Produto1", "Garrafa");
        Produto p2 = new Produto("Produto1", "Lata");
        Cartao c1 = new Cartao("222333", "Star Citizen");
        Cartao c2 = new Cartao("222333", "Star Bank");

        Facade facade = new ControladorDesconto();
        facade.calcularDesconto(c1, p1, 13);
        facade.calcularDesconto(c2, p2, 13);
    }
}
