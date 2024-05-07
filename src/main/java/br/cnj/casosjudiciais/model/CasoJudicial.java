package br.cnj.casosjudiciais.model;


public class CasoJudicial {
    private int numero;
    private char decisao;
    private String descricao;

    public CasoJudicial() {
    }

    public CasoJudicial(int numero, char decisao, String descricao) {
        this.numero = numero;
        this.decisao = decisao;
        this.descricao = descricao;
    }
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public char getDecisao() {
        return decisao;
    }
    public void setDecisao(char decisao) {
        this.decisao = decisao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}