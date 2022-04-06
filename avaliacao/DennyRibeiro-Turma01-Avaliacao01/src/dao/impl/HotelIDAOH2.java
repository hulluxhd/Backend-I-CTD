package dao.impl;

import dao.IDao;
import dao.config.ConfigJDBC;
import model.Hotel;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelIDAOH2 implements IDao<Hotel> {
    private static final Logger logger = Logger.getLogger(HotelIDAOH2.class);
    private ConfigJDBC configJDBC;

    public HotelIDAOH2(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }

    @Override
    public Hotel salvar(Hotel hotel) {

        Connection connection = configJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
                "INSERT INTO hoteis (nomeFilial, rua, numero, cidade, estado, isFiveStar) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                hotel.getNomeFilial(),
                hotel.getRua(),
                hotel.getNumero(),
                hotel.getCidade(),
                hotel.getEstado(),
                hotel.getIsFiveStar()
        );

        try{
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) hotel.setId(keys.getInt(1));
            statement.close();
            connection.close();

            logger.info("Filial cadastrada com sucesso. Id: " + hotel.getId() + "...");

        } catch (SQLException e){
            e.printStackTrace();
        }


        return hotel;
    }
}
