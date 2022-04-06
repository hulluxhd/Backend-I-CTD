import model.Leao;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        // Alternativa para configurar o log4j.properties
        BasicConfigurator.configure();
        Leao leao = new Leao();
        leao.setIdade(4);
        leao.setNome("Simba");
        leao.setAlpha(true);
        leao.correr();
    }
}
