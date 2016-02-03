package br.ufjf.dcc;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aula14Exm01 {

    public static void main(String[] args) {
        try {
            VisitanteDAO dao;

            dao = VisitanteDAOFactory.getDAO(VisitanteDAOFactory.DAO_ARQUIVO);
            List<Visitante> visitantes = dao.listaTodos();
            for (Visitante visitante : visitantes) {
                System.out.println(visitante);
            }
        } catch (Exception ex) {
            Logger.getLogger(Aula14Exm01.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
