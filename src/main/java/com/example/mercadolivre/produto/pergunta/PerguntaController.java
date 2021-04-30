package com.example.mercadolivre.produto.pergunta;

import com.example.mercadolivre.produto.Produto;
import com.example.mercadolivre.produto.ProdutoRepository;
import com.example.mercadolivre.usuario.Usuario;
import com.example.mercadolivre.usuario.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("perguntas")
public class PerguntaController {

    private PerguntaRepository perguntaRepository;
    private UsuarioRepository usuarioRepository;
    private ProdutoRepository produtoRepository;

    public PerguntaController(PerguntaRepository perguntaRepository,
                              UsuarioRepository usuarioRepository,
                              ProdutoRepository produtoRepository) {
        this.perguntaRepository = perguntaRepository;
        this.usuarioRepository = usuarioRepository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public void salvarPergunta(@RequestBody @Valid PergutaRequest pergutaRequest,
                                         Principal principal){

        perguntaRepository.save(pergutaRequest.toPergunta(principal.getName(),usuarioRepository));

        Long idproduto = pergutaRequest.getProduto().getId();

        Optional<Produto> produto = produtoRepository.findById(idproduto);

        if(produto.isPresent()){
            Optional<Usuario> usuario = usuarioRepository.findById(produto.get().getUsuario().getId());
            if(usuario.isPresent()){
                String emailDonoProduto = usuario.get().getEmail();
                SendEmail sendEmail = new SendEmail(principal.getName(),emailDonoProduto,
                        "Uma nova pergunta no seu produto",pergutaRequest.getPergunta());
                System.out.println(sendEmail);
            }
        }

    }
}

