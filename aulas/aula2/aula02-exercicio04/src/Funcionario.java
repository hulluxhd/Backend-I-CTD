public abstract class Funcionario {
    private String nome;
    private String categoria;
    private int quantidadeVendas = 0;

    public Funcionario(String nome) {
        this.nome = nome;

    }
    public void mostrarCategoria(){
       int pontos = calcularPontos();
       recategorizar(pontos);

       System.out.println(this.categoria);

    }

    public String recategorizar(int pontos){
        if (pontos <= 20){
            this.setCategoria("Novato");
            return "Novato";
        } else if (pontos <= 30){
            this.setCategoria("Aprendiz");
            return "Aprendiz";
        } else if (pontos <= 40){
            this.setCategoria("Bom");
            return "Bom";
        } else {
            this.setCategoria("Mestre");
            return "Mestre";
        }
    }

    public abstract int calcularPontos();

    public void realizarVenda(int qtdVendas){
        this.setQuantidadeVendas(this.getQuantidadeVendas() + qtdVendas);
        System.out.println("Venda(s) registrada(s): " + qtdVendas + ".");
    };

    // getters and setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }





    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void setQuantidadeVendas(int quantidadeVendas) {
        this.quantidadeVendas = quantidadeVendas;
    }
}