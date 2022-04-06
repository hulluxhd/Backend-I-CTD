package dao.config;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigJDBC {
    private static final Logger logger = Logger.getLogger(ConfigJDBC.class);
    private final String driver, url, user, password;

    public ConfigJDBC(String driver, String url, String user, String password) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public ConfigJDBC() {
        this.driver = "org.H2.Driver";
        this.url = "jdbc:h2:mem:avaliacao;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql'";
        this.user = "sa";
        this.password = "";
    }

    public Connection conectarComBancoDeDados(){

        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        logger.info("Conexão estabelecida com " + url + "...");
        return connection;
    }


}
