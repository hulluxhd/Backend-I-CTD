import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Projeto {
    private static final Logger logger = Logger.getLogger(Projeto.class);
    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        Leao leao = new Leao("Denny", 25, true);
        leao.correr();
        leao.maior10();
    }


}
