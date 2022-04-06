package info;

import model.ServicoInterface;
import org.junit.jupiter.api.Test;
import service.ServicoProxy;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoTest {

    @Test
    void Teste1(){
        Documento doc1 = new Documento("1", "htttp://#", "Teste de mensagem: VACINA MATA BEBE; ARTHUR DO VAL É UM LOSSSSSGO");
        doc1.addEmail("denny.ribeiro@outlook.com");
        ServicoInterface s1 = new ServicoProxy();
        s1.acessarConteudo("denny.ribeiro@outlook.com", "http://#", doc1);

    }

}