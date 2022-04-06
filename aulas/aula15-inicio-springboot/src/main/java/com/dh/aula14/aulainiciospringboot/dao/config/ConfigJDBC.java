package com.dh.aula14.aulainiciospringboot.dao.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigJDBC {
    private String jdbcDriver;
    private final String dbUrl;
    private final String nomeUsuario;
    private final String senhaUsuario;

    public ConfigJDBC() { // config da conexão com o BD
        this.jdbcDriver = "com.mysql.cj.jdbc.Driver";
        this.dbUrl = "jdbc:mysql://localhost:3306/BD_clinica";
        this.nomeUsuario = "root";
        this.senhaUsuario = "";
    }

    public Connection conectarComBancoDeDados() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    dbUrl, nomeUsuario, senhaUsuario);
            String a = "Conexão com o Banco de Dados efetuada com sucesso!";
            System.out.println(a);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
