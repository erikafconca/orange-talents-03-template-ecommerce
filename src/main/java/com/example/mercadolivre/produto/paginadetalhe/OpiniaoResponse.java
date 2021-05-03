package com.example.mercadolivre.produto.paginadetalhe;

public class OpiniaoResponse {

    private Integer nota;
    private String titulo;
    private String descricao;

    public OpiniaoResponse(Integer nota, String titulo, String descricao) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Integer getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}
