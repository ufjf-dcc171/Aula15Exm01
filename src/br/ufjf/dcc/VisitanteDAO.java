package br.ufjf.dcc;

import java.util.List;

public interface VisitanteDAO {
    
    List<Visitante> listaTodos() throws Exception;
    Visitante buscaPorId(Long id) throws Exception;
    void exclui(Visitante visitante) throws Exception;
    void atualiza(Visitante visitante) throws Exception;
    void cria(Visitante visitante) throws Exception;
    
}
