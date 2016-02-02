package br.ufjf.dcc;

class SaidaInvalidaException extends Exception {

    SaidaInvalidaException() {
        super("A entrada deve ser anterior à saida!");
    }
    
}
