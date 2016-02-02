package br.ufjf.dcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection conexao = null;
    
    public static Connection getConnection() throws SQLException{
        if(conexao==null){
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lp3-exm", "fulano", "senha");
        }
        return conexao;
    }
    
    public static void closeConnection() throws SQLException{
        if(conexao!=null){
            conexao.close();
            conexao = null;
        }
    }
}
