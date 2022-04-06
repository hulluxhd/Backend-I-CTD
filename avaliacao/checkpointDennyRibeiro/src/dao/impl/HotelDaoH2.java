package dao.impl;

import dao.IDao;
import dao.config.ConfigJDBC;
import model.Hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelDaoH2 implements IDao<Hotel>{

    private ConfigJDBC configJDBC;

    public HotelDaoH2(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }

    @Override
    public Hotel salvar(Hotel hotel) {
        Connection connection = configJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
                "INSERT INTO hoteis " +
                        "(nomeFilial, rua, numero, cidade, estado, estrelas) " +
                        "VALUES ('%s','%s','%s','%s','%s','%s')",
                hotel.getNomeFilial(),
                hotel.getRua(),
                hotel.getNumero(),
                hotel.getCidade(),
                hotel.getEstado(),
                hotel.getEstrelas()
        );

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next())
                hotel.setId(keys.getInt(1));
            statement.close();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return hotel;
    }
}
