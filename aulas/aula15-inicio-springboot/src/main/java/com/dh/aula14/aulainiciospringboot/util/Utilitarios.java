package com.dh.aula14.aulainiciospringboot.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

public class Utilitarios {

    public static Timestamp dateToTimestamp(Date data){
        Timestamp timestamp = new Timestamp(data.getTime());
        return timestamp;
    }

    public static void abrirConexaoEexecutarQuery(Connection conexao, Statement stmt, String query){
        try{
            stmt = conexao.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conexao.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}
