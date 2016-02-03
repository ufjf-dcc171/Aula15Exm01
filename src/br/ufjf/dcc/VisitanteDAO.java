package br.ufjf.dcc;

import java.util.List;

public interface VisitanteDAO {

    List<Visitante> listaTodos() throws Exception;
    void cria(Visitante visitante) throws Exception;
    
}
