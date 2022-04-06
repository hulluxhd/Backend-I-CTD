import java.util.ArrayList;

public class Vendedor extends Funcionario{
    private ArrayList<Afiliado> listaAfiliados = new ArrayList<>();
    private int quantidadeAfiliadosObtidos = 0;

    public Vendedor(String nome) {
        super(nome);

    }

    public Afiliado obterAfiliado(Afiliado afiliado){
        listaAfiliados.add(afiliado);
        this.quantidadeAfiliadosObtidos = listaAfiliados.size();
        System.out.println("Afiliado registrado");
        return afiliado;
    }

    @Override
    public int calcularPontos() {
        int pontos = this.getQuantidadeAfiliadosObtidos() * 10 + super.getQuantidadeVendas() * 5;
        System.out.println("Seus pontos totais são: " + pontos);
        return pontos;
    }

    // getters and setters
    public int getQuantidadeAfiliadosObtidos() {
        return quantidadeAfiliadosObtidos;
    }

    public void setQuantidadeAfiliadosObtidos(int quantidadeAfiliadosObtidos) {
        this.quantidadeAfiliadosObtidos = quantidadeAfiliadosObtidos;
    }
}
