public class Temporario extends Funcionario{
    private int horasTrabalhadas;
    private double valorHora;

    public Temporario(String nome, String conta, double saldo, int horasTrabalhadas, double valorHora) {
        super(nome, conta, saldo);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calculoDoSalario() {
        return this.getValorHora() * this.getHorasTrabalhadas();
    }

    @Override
    public void impressaoDoRecibo() {
        System.out.println("IMPRESSÃO DIGITAL \nValor recebido: R$" + calculoDoSalario());
    }

    @Override
    public void deposito() {
        super.setSaldo(super.getSaldo() + calculoDoSalario());
    }


    // getters and settewrs
    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
