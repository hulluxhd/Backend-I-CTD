import info.Documento;
import model.ServicoInterface;
import service.ServicoProxy;

public class Main {
    public static void main(String[] args) {
        Documento doc1 = new Documento("1", "htttp://#", "Teste de mensagem");
        doc1.addEmail("denny.ribeiro@outlook.com");
        ServicoInterface s1 = new ServicoProxy();
        s1.acessarConteudo("denny.ribeiro@outlook.co", "http://#", doc1);

    }
}
