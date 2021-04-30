package com.example.mercadolivre.produto.foto;

import com.example.mercadolivre.produto.Produto;

import javax.persistence.*;

@Entity
public class Foto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String linkImagem;

    @ManyToOne
    private Produto produto;

    public Foto() {
    }

    public Foto(String linkImagem, Produto produto) {
        this.linkImagem = linkImagem;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

    public Produto getProduto() {
        return produto;
    }
}
