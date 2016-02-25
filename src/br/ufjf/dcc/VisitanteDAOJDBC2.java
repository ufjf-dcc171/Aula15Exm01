package br.ufjf.dcc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VisitanteDAOJDBC2 implements VisitanteDAO {

    private final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static VisitanteDAOJDBC2 instancia;
    private PreparedStatement opListaTodos;
    private PreparedStatement opCriaVisitante;
    private PreparedStatement opListaPorID;
    private PreparedStatement opExcluiPorID;
    private PreparedStatement opAtualiza;

    public VisitanteDAOJDBC2() throws Exception {
        try {
            Connection conexao = Conexao.getConnection();
            opListaTodos = conexao.prepareStatement("SELECT * FROM visitante");
            opListaPorID = conexao.prepareStatement("SELECT * FROM visitante WHERE id=?");
            opCriaVisitante = conexao.prepareStatement("INSERT INTO visitante(nome, idade, entrada) VALUES(?,?,?)", new String[]{"id"});
            opExcluiPorID = conexao.prepareStatement("DELETE FROM visitante WHERE id=?");
            opAtualiza = conexao.prepareStatement("UPDATE visitante SET nome=?, idade=?, entrada=?, saida=? WHERE id=?");
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public static VisitanteDAOJDBC2 getInstancia() {
        if (instancia == null) {
            try {
                instancia = new VisitanteDAOJDBC2();
            } catch (Exception ex) {
                return null;
            }
        }
        return instancia;
    }

    @Override
    public List<Visitante> listaTodos() throws Exception {
        try {
            List<Visitante> visitantes = new ArrayList<>();

            ResultSet resultado = opListaTodos.executeQuery();
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

            opCriaVisitante.clearParameters();
            opCriaVisitante.setString(1, visitante.getNome());
            opCriaVisitante.setInt(2, visitante.getIdade());
            opCriaVisitante.setTimestamp(3, new java.sql.Timestamp(visitante.getEntrada().getTime()));
            opCriaVisitante.executeUpdate();

            ResultSet resultado = opCriaVisitante.getGeneratedKeys();
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

            opListaPorID.setLong(1, id);
            ResultSet resultado = opListaPorID.executeQuery();
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
            opExcluiPorID.setLong(1, visitante.getId());
            opExcluiPorID.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void atualiza(Visitante visitante) throws Exception {
        try {
            opAtualiza.setString(1, visitante.getNome());
            opAtualiza.setInt(2, visitante.getIdade());
            opAtualiza.setTimestamp(3, new java.sql.Timestamp(visitante.getEntrada().getTime()));
            opAtualiza.setTimestamp(4, new java.sql.Timestamp(visitante.getSaida().getTime()));
            opAtualiza.setLong(5, visitante.getId());
            opAtualiza.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }

    }

}
