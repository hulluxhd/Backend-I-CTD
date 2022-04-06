public class Vegetariano extends Cardapio{
    private double adicionalVegetariano;

    public Vegetariano(double precoBase, double precoBaseContainer, int quantidade, double adicionalVegetariano) {
        super(precoBase, precoBaseContainer, quantidade);
        this.adicionalVegetariano = adicionalVegetariano;
    }

    @Override
    public double montar() {
        System.out.println("VEGETARIANO");
        return ((getPrecoBaseContainer() * this.adicionalVegetariano) * (1 + 0.01));
    }
}
