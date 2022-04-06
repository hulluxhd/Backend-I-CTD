package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigJDBC {
    private String JDBCDriver;
    private String url;
    private String user;
    private String password;

    public ConfigJDBC(String JDBCDriver, String url, String user, String password) {
        this.JDBCDriver = JDBCDriver;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public ConfigJDBC() {
        this.JDBCDriver = "org.h2.Driver";
        this.url = "jdbc:h2:mem:avaliacao";
        this.user = "sa";
        this.password = "";
    }

    public Connection criarConexaocComBD(){

        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Funcionando DB");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;


    }

}
