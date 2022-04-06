import model.Roupa;
import service.RoupaFactory;

public class Main {
    public static void main(String[] args) {
        RoupaFactory roupaFactory = new RoupaFactory();

        System.out.println(roupaFactory.addRoupa(new Roupa("M", "Calça", false, true)));
        System.out.println(roupaFactory.addRoupa(new Roupa("M", "Calça", false, true)));
        System.out.println(roupaFactory.getTamanhoM().size());
    }
}
