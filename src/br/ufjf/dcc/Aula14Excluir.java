package br.ufjf.dcc;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Aula14Excluir {

    public static void main(String[] args) {
        try {
            VisitanteDAO dao;

            dao = VisitanteDAOFactory.getDAO(VisitanteDAOFactory.DAO_JDBC);
            Visitante visitante = dao.buscaPorId(2L);
            System.out.println(visitante);
            dao.exclui(visitante);
            Visitante visitante2 = dao.buscaPorId(2L);
            System.out.println(visitante2);
        } catch (Exception ex) {
            Logger.getLogger(Aula14Excluir.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
