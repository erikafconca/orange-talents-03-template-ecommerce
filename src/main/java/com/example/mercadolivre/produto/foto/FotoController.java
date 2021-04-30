package com.example.mercadolivre.produto.foto;

import com.example.mercadolivre.produto.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("fotos")
public class FotoController {

    private FotoRepository repository;
    private ProdutoRepository produtoRepository;

    public FotoController(FotoRepository repository,
                          ProdutoRepository produtoRepository) {

        this.repository = repository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Foto salvarFoto(@RequestBody @Valid FotoRequest fotoRequest,
                           Principal principal){

        String email = principal.getName(); //retorna um email de quem está logado

        System.out.println("email no controller " + email);

        Foto foto = fotoRequest.toFoto(email, produtoRepository);

        Foto fotoSalva = repository.save(foto);


        return  fotoSalva;

    }

}
