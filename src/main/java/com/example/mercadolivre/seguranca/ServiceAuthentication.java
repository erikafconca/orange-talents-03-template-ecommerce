package com.example.mercadolivre.seguranca;

import com.example.mercadolivre.usuario.Usuario;
import com.example.mercadolivre.usuario.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceAuthentication  implements UserDetailsService {

    private UsuarioRepository repository;

    public ServiceAuthentication(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Usuario> optUsuario = repository.findByEmail(s);
        if(optUsuario.isPresent()){
            return optUsuario.get();
        }

        throw new UsernameNotFoundException("Dados Inválidos");
    }
}
