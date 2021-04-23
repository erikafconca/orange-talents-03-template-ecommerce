package com.example.mercadolivre.usuario;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private LocalDateTime instanteCriacao;

    @Deprecated
    public Usuario() {
    }

    public Usuario(String email, String senha, LocalDateTime instanteCriacao) {
        this.email = email;
        this.senha = senha;
        this.instanteCriacao = instanteCriacao;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }
}
