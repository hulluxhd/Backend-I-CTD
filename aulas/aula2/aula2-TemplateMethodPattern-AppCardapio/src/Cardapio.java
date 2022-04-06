public abstract class Cardapio {
    private double precoBase, precoBaseContainer;
    private int quantidade;


    public Cardapio(double precoBase, double precoBaseContainer, int quantidade) {
        this.precoBase = precoBase;
        this.precoBaseContainer = precoBaseContainer;
        this.quantidade = quantidade;
    }

    public double calcularPreco(){
        double precoMontagem = montar();
        double precoBase = getPrecoBase();
        informacoes(precoBase, precoMontagem);
        return (precoBase + precoMontagem) * getQuantidade();
    }

    public abstract double montar();

    public void informacoes(double precoBase, double montagem){
        System.out.println("O pedido tem um custo base de R$" + precoBase * getQuantidade() + " + um custo de montagem de R$" + montagem * getQuantidade() + ". O valor final é de R$" + (precoBase + montagem) * getQuantidade());
    }

    // getters and setters

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoBaseContainer() {
        return precoBaseContainer;
    }

    public void setPrecoBaseContainer(double precoBaseContainer) {
        this.precoBaseContainer = precoBaseContainer;
    }
}
