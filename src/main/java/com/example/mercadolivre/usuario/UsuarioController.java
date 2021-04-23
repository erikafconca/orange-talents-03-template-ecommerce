package com.example.mercadolivre.usuario;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public void salvarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest){
        usuarioRepository.save(usuarioRequest.toUsuario());
    }

}
