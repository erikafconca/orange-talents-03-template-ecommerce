package com.example.mercadolivre.categoria;

import com.example.mercadolivre.validadores.Groups;
import com.example.mercadolivre.validadores.ValidarCamposDuplicados;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

public class CategoriaRequest {

    @NotBlank
    @ValidarCamposDuplicados(atributo = "nome", aClass = Categoria.class)
    private String nome;

    @Valid
    @ConvertGroup(from = Default.class, to = Groups.Categoria.class)
    private Categoria categoriaMae;

    public CategoriaRequest(String nome, Categoria categoriaMae) {
        this.nome = nome;
        this.categoriaMae = categoriaMae;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoriaMae() {
        return categoriaMae;
    }

    public Categoria toCategoria() {
        return new Categoria(nome, categoriaMae);
    }
}
