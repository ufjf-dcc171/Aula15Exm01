package br.ufjf.dcc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VisitanteDAOJDBC implements VisitanteDAO {

    private static VisitanteDAOJDBC instancia;

    public static VisitanteDAOJDBC getInstancia() {
        if (instancia == null) {
            instancia = new VisitanteDAOJDBC();
        }
        return instancia;
    }

    @Override
    public List<Visitante> listaTodos() throws Exception {
        try {
            Connection conexao = Conexao.getConnection();
            List<Visitante> visitantes = new ArrayList<>();
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM visitante");
            while (resultado.next()) {
                Visitante visitante = new Visitante();
                visitante.setNome(resultado.getString("nome"));
                visitante.setIdade(resultado.getInt("idade"));
                visitante.setEntrada(resultado.getTimestamp("entrada"));
                visitante.setSaida(resultado.getTimestamp("entrada"));
                visitantes.add(visitante);
            }
            return visitantes;
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void cria(Visitante visitante) throws Exception {
        try {
            Connection conexao = Conexao.getConnection();
            List<Visitante> visitantes = new ArrayList<>();
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("INSERT INTO visitante VALUES('"
                    + visitante.getNome()
                    + "',"
                    + visitante.getIdade()
                    + ",CURRENT_TIMESTAMP)");

        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
}
