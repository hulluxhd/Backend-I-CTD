public class Estagiario extends Funcionario {
    public Estagiario(String nome) {
        super(nome);
    }

    @Override
    public String recategorizar(int pontos) {
        if (pontos <= 50) {
            super.setCategoria("Estagiário novato");
            System.out.println("O estagiário " + super.getNome() + " tem " + pontos + " pontos e categoriza como " + super.getCategoria());
            return super.getCategoria();
        } else {
            super.setCategoria("Estagiário experiente");
            System.out.println("O estagiário " + super.getNome() + " tem " + pontos + " pontos e categoriza como " + super.getCategoria());
            return super.getCategoria();
        }
    }

    @Override
    public int calcularPontos() {
        int pontos = super.getQuantidadeVendas() * 5;

        return pontos;
    }
}
