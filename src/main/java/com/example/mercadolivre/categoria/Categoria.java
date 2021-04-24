package com.example.mercadolivre.categoria;

import com.example.mercadolivre.validadores.Groups;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {
    @Id
    @NotNull(groups = Groups.Categoria.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Categoria categoriaMae;


    public Categoria() {
    }

    public Categoria(String nome, Categoria categoriaMae) {
        this.nome = nome;
        this.categoriaMae = categoriaMae;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoriaMae() {
        return categoriaMae;
    }
}
