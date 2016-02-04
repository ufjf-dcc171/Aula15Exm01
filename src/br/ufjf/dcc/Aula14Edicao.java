package br.ufjf.dcc;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Aula14Edicao {

    public static void main(String[] args) {
        try {
            VisitanteDAO dao;

            dao = VisitanteDAOFactory.getDAO(VisitanteDAOFactory.DAO_JDBC);
            Visitante visitante = dao.buscaPorId(3L);
            System.out.println(visitante);
            visitante.setNome("Fulaninho");
            dao.atualiza(visitante);
            Visitante visitante2 = dao.buscaPorId(3L);
            System.out.println(visitante2);
        } catch (Exception ex) {
            Logger.getLogger(Aula14Edicao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
