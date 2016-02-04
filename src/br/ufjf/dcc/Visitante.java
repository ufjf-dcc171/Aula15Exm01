package br.ufjf.dcc;

import java.util.Date;

public class Visitante {
    private Long id;
    private String nome;
    private Integer idade;
    private Date entrada = new Date();
    private Date saida = null;

    public Visitante() {
        this(null, null);
    }

    public Visitante(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) throws Exception {
        if(idade <= 0) throw new Exception("A idade deve ser maior que 0!");
        this.idade = idade;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) throws Exception {
        if(saida!=null && entrada.after(saida)) throw new Exception("A entrada deve ser anterior à saida!");
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) throws SaidaInvalidaException {
        if(saida!=null && entrada.after(saida)) throw new SaidaInvalidaException();
        this.saida = saida;
    }

    @Override
    public String toString() {
        return "Visitante{id=" +id+ " nome=" + nome + ", idade=" + idade + ", entrada=" + entrada + ", saida=" + saida + '}';
    }

    void setId(Long novoId) {
        this.id = novoId;
    }

    public Long getId() {
        return id;
    }

    
    
    
}
