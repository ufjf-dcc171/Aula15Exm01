package br.ufjf.dcc;

/**
 *
 * @author igor
 */
class VisitanteDAOFactory {

    public static VisitanteDAO getDAO(int tipo) {
        switch (tipo) {
            case DAO_JDBC:
                return VisitanteDAOJDBC.getInstancia();
            default:
                return VisitanteDAOArquivo.getInstancia();
        }

    }
    public static final int DAO_ARQUIVO = 0;
    public static final int DAO_JDBC = 1;

}
