package test;

import dao.config.ConfigJDBC;
import dao.impl.HotelDaoH2;
import model.Hotel;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.HotelService;

import static org.junit.jupiter.api.Assertions.*;

class HotelServiceTest {
    private static final Logger LOGGER = Logger.getLogger(HotelServiceTest.class);

    private HotelService hotelService = new HotelService(new HotelDaoH2( new ConfigJDBC()));

    @BeforeAll
    static void ConfigLog() {

        BasicConfigurator.configure();
    }

    @Test
    public void cadastrarEnderecoNoH2() {
        LOGGER.info("Cadastrando o hotel no H2...");
        Hotel hotel = new Hotel("Hotel Plaza","Avenida Gonçalo Dias",22,
                "Fortaleza","CE", true);
        Hotel hotelRetornado = hotelService.salvar(hotel);
        LOGGER.info("Endereco criado com id " + hotelRetornado.getId());
    }
}