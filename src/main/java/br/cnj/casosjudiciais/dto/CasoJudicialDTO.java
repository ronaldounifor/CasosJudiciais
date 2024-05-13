package br.cnj.casosjudiciais.dto;

public class CasoJudicialDTO {
    private int numero;
    private char decisao;
    private String descricao;
    
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
