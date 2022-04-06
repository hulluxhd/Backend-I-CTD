import java.time.LocalDate;

public class Credito extends Cartao{
    private double limite, saldoUtilizado;

    public Credito(String numeros, String codigo, LocalDate dataValidade, double limite) {
        super(numeros, codigo, dataValidade);
        this.limite = limite;
    }


}
