package br.ufjf.dcc;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Aula14Cria {

    public static void main(String[] args) {
        try {
            VisitanteDAO dao;

            dao = VisitanteDAOFactory.getDAO(VisitanteDAOFactory.DAO_JDBC);
            
            Visitante v = new Visitante("Beltraninho", 7);
            System.out.println("Antes de persistir: "+v);
            dao.cria(v);
            System.out.println("Depois de persistir: "+v);
            
            
        } catch (Exception ex) {
            Logger.getLogger(Aula14Cria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
