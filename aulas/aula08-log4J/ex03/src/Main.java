import model.Lista;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        Lista lista = new Lista();
        for (int i = 1; i < 15; i++){
            lista.addNumero(i*(-1));
        }
        lista.calculaMedia();
    }
}
