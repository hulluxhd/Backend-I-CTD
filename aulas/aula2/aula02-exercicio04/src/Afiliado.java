public class Afiliado extends Funcionario{

    public Afiliado(String nome) {
        super(nome);
    }

    @Override
    public int calcularPontos() {

        int pontos = super.getQuantidadeVendas() * 15;
        System.out.println("Seus pontos totais são: " + pontos);
        return pontos;
    }


}
