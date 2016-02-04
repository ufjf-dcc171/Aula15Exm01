package br.ufjf.dcc;

import java.util.List;


class VisitanteDAOArquivo implements VisitanteDAO{
    private static VisitanteDAOArquivo instancia = null;
    
    static VisitanteDAOArquivo getInstancia() {
        if(instancia == null){
            instancia = new VisitanteDAOArquivo();
        }
        return instancia;
    }

    
    @Override
    public List<Visitante> listaTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Visitante buscaPorId(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exclui(Visitante visitante) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualiza(Visitante visitante) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cria(Visitante visitante) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
