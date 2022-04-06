package dao.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// classe que puxa a conexão com o BD
public class ConfigJDBC {

    private String jdbcDriver;
    private String url;
    private String user;
    private String password;

    public ConfigJDBC(String jdbcDriver, String url, String user, String password) {
        this.jdbcDriver = jdbcDriver;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public ConfigJDBC() {
        this.jdbcDriver = "org.H2.Driver";
        this.url = "jdbc:h2:mem:DB;" +
                "DB_CLOSE_DELAY=-1;" +
                "INIT=RUNSCRIPT FROM 'create.sql'";
        this.user = "sa";
        this.password = "";
    }

    //Método que abre a conexão

    public Connection conectarComBancoDeDados(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão aberta!");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
