package com.example.mercadolivre.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class UsuarioRequest {
    @Email @NotBlank
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private LocalDateTime instanteCriacao;

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
        return new Usuario(email, senha, instanteCriacao );
    }
}
