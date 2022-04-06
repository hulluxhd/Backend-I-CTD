public abstract class Funcionario {

    private String nome;
    private String conta;
    private double saldo;

    public Funcionario(String nome, String conta, double saldo) {
        this.nome = nome;
        this.conta = conta;
        this.saldo = saldo;
    }

    public double pagamentoSalario(){
        double valorSalario = calculoDoSalario();
        impressaoDoRecibo();
        deposito();
    }


    public abstract double calculoDoSalario();
    public abstract void impressaoDoRecibo();
    public abstract void deposito();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
