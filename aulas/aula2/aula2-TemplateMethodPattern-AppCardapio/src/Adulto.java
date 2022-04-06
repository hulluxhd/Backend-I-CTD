public class Adulto extends Cardapio{
    public Adulto(double precoBase, double precoBaseContainer, int quantidade) {
        super(precoBase, precoBaseContainer, quantidade);
    }

    @Override
    public double montar() {
        return super.getPrecoBaseContainer();
    }
}
