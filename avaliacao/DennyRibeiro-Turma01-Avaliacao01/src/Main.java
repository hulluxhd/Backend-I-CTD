import dao.config.ConfigJDBC;
import dao.impl.HotelIDAOH2;
import model.Hotel;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import service.HotelService;

public class Main {
    private static final Logger logger = Logger.getLogger(ConfigJDBC.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        Hotel h1 = new Hotel("Filial 1", "Rua não interessa", "001", "Fim do Mundo", "Inversão", 1);
        Hotel h2 = new Hotel("Filial 2", "Rua não interessa mesmo", "002", "Pico", "Magnetica", 0);
        Hotel h3 = new Hotel("Filial 3", "Rua não interessa pra caralho", "003", "Da", "Historia", 0);
        Hotel h4 = new Hotel("Filial 4", "Rua não interessa a ninguem", "004", "Bandeira", "Corrompida", 1);
        Hotel h5 = new Hotel("Filial 5", "Rua não interessa, a rua e minha", "005", "Anuns", "Mesmo", 1);


        HotelService hotelService = new HotelService(new HotelIDAOH2(new ConfigJDBC()));

        hotelService.salvar(h1);
        hotelService.salvar(h2);
        hotelService.salvar(h3);
        hotelService.salvar(h4);
        hotelService.salvar(h5);

    }
}
