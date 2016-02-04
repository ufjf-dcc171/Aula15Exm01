package br.ufjf.dcc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VisitanteDAOJDBC implements VisitanteDAO {

    private final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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
                visitante.setId(resultado.getLong("id"));
                visitante.setNome(resultado.getString("nome"));
                visitante.setIdade(resultado.getInt("idade"));
                visitante.setEntrada(resultado.getTimestamp("entrada"));
                visitante.setSaida(resultado.getTimestamp("saida"));
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
            Statement operacao = conexao.createStatement();

            operacao.executeUpdate("INSERT INTO visitante(nome, idade, entrada) VALUES('"
                    + visitante.getNome()
                    + "',"
                    + visitante.getIdade()
                    + ",CURRENT_TIMESTAMP)", new String[]{"id"});
            ResultSet resultado = operacao.getGeneratedKeys();
            if (resultado.next()) {
                visitante.setId(resultado.getLong(1));
            }

        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Visitante buscaPorId(Long id) throws Exception {
        try {
            Connection conexao = Conexao.getConnection();
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM visitante WHERE id=" + id);
            if (resultado.next()) {
                Visitante visitante = new Visitante();
                visitante.setId(resultado.getLong("id"));
                visitante.setNome(resultado.getString("nome"));
                visitante.setIdade(resultado.getInt("idade"));
                visitante.setEntrada(resultado.getTimestamp("entrada"));
                visitante.setSaida(resultado.getTimestamp("saida"));
                return visitante;
            }
            return null;
        } catch (SQLException ex) {
            throw new Exception(ex);
        }

    }

    @Override
    public void exclui(Visitante visitante) throws Exception {
        if (visitante.getId() == null) {
            return;
        }
        try {
            Connection conexao = Conexao.getConnection();
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("DELETE FROM visitante WHERE id = " + visitante.getId());
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void atualiza(Visitante visitante) throws Exception {
        try {
            Connection conexao = Conexao.getConnection();

            Statement operacao = conexao.createStatement();

            String strEntrada = (visitante.getEntrada() != null) ? "'" + formater.format(visitante.getEntrada()) + "'" : "NULL";
            String strSaida = (visitante.getSaida() != null) ? "'" + formater.format(visitante.getSaida()) + "'" : "NULL";
            operacao.executeUpdate(
                    "UPDATE visitante SET nome='"
                    + visitante.getNome() + "', idade="
                    + visitante.getIdade() + ", entrada="
                    + strEntrada + ", saida="
                    + strSaida + " WHERE id=" + visitante.getId());
        } catch (SQLException ex) {
            throw new Exception(ex);
        }

    }

}
