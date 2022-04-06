import java.time.LocalDate;

public class Debito extends Cartao{
    private double saldoDisponivel;

    public Debito(String numeros, String codigo, LocalDate dataValidade, double saldoDisponivel) {
        super(numeros, codigo, dataValidade);
        this.saldoDisponivel = saldoDisponivel;
    }


}
