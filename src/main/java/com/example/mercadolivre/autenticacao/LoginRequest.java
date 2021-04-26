package com.example.mercadolivre.autenticacao;

import com.example.mercadolivre.usuario.SenhaLimpa;
import com.example.mercadolivre.usuario.Usuario;

public class LoginRequest {

    private String email;
    private String senha;

    public LoginRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario toUsuario(){
        return new Usuario(email, new SenhaLimpa(senha));
    }
}
