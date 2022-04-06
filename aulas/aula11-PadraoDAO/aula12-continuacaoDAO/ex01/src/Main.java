import dao.config.ConfigJDBC;
import dao.implement.EnderecoDAOH2;
import model.Endereco;
import service.EnderecoService;

public class Main {
    public static void main(String[] args) throws Exception {
        EnderecoService enderecoService = new EnderecoService(new EnderecoDAOH2(new ConfigJDBC()));

        Endereco e1 = new Endereco(12, "rua 2", "Fortaleza", "CE");
        Endereco e2 = new Endereco(12212, "rua 12122", "Forta3213leza", "CE");

        enderecoService.salvar(e1);
        enderecoService.salvar(e2);
        enderecoService.pesquisar(e1.getId());

    }
}
