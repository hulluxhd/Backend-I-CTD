import dao.ConfigJDBC;
import dao.IDao;
import dao.impl.MedicamentoDaoH2;
import model.Medicamento;
import service.MedicamentoService;

public class Main {
    public static void main(String[] args) {
        MedicamentoService medicamentoService = new MedicamentoService(
                new MedicamentoDaoH2()
        );
        Medicamento medicamento = new Medicamento("Diazepam", "Morte Certa", 2, 15.0);
        medicamentoService.salvar(medicamento);
}}
