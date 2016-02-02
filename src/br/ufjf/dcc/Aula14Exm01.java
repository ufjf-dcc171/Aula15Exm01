package br.ufjf.dcc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aula14Exm01 {

    public static void main(String[] args) {
        try {
            Connection conexao = Conexao.getConnection();
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM visitante");
            while(resultado.next()){
                Visitante visitante = new Visitante();
                visitante.setNome(resultado.getString("nome"));
                visitante.setIdade(resultado.getInt("idade"));
                visitante.setEntrada(resultado.getTimestamp("entrada"));
                visitante.setSaida(resultado.getTimestamp("entrada"));
                System.out.println(visitante);
            }
                    
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Aula14Exm01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SaidaInvalidaException e ){
            System.err.println("Saída inválida!");
        }
        catch (Exception ex) {
            Logger.getLogger(Aula14Exm01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
