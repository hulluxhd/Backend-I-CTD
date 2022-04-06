public class Infantil extends Cardapio{
    private double adicionalInfantil;

    public Infantil(double precoBase, double precoBaseContainer, int quantidade, double adicionalInfantil) {
        super(precoBase, precoBaseContainer, quantidade);
        this.adicionalInfantil = adicionalInfantil;
    }

    @Override
    public double montar() {

        System.out.println("INFANTIL");

        return getPrecoBaseContainer() + this.adicionalInfantil;
    }
}
