public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Efetivo("Denny", "222", 0, 2000, 200, 150);
        Funcionario f2 = new Temporario("Joyce", "111", 0, 144, 35);

        f1.pagamentoSalario();
        f2.pagamentoSalario();

        System.out.println(f1.getSaldo());
        System.out.println(f2.getSaldo());
    }
}
