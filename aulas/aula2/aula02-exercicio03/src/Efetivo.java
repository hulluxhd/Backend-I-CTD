public class Efetivo extends Funcionario{
    private double salarioBase;
    private double descontos;
    private double bonificacoes;

    public Efetivo(String nome, String conta, double saldo, double salarioBase, double descontos, double bonificacoes) {
        super(nome, conta, saldo);
        this.salarioBase = salarioBase;
        this.descontos = descontos;
        this.bonificacoes = bonificacoes;
    }

    @Override
    public double calculoDoSalario() {
        return this.getSalarioBase() + this.getBonificacoes() - this.getDescontos();
    }

    @Override
    public void impressaoDoRecibo() {
        System.out.println("IMPRESSÃO EM PAPEL \nValor recebido: R$" + calculoDoSalario());
    }

    @Override
    public void deposito() {
        super.setSaldo(super.getSaldo() + calculoDoSalario());
    }

    // getters and setters


    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getDescontos() {
        return descontos;
    }

    public void setDescontos(double descontos) {
        this.descontos = descontos;
    }

    public double getBonificacoes() {
        return bonificacoes;
    }

    public void setBonificacoes(double bonificacoes) {
        this.bonificacoes = bonificacoes;
    }
}
