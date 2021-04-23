package com.example.mercadolivre.usuario;

import com.example.mercadolivre.validadores.ValidarCamposDuplicados;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioRequest {
    @Email @NotBlank
    @ValidarCamposDuplicados(atributo = "email", aClass = Usuario.class)
    private String email;
    @NotBlank
    private String senha;

    public UsuarioRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }


    public Usuario toUsuario() {
        return new Usuario(email, senha );
    }
}
