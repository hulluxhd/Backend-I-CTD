package tests;

import dao.config.ConfigJDBC;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigJDBCTest {

    ConfigJDBC configJDBC = new ConfigJDBC();

    @Test
    public void conectarBD(){
        configJDBC.conectarComBancoDeDados();
    }

}