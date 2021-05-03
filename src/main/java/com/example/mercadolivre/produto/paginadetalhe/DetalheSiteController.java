package com.example.mercadolivre.produto.paginadetalhe;

import com.example.mercadolivre.produto.ProdutoRepository;
import com.example.mercadolivre.produto.foto.FotoRepository;
import com.example.mercadolivre.produto.opiniao.OpiniaoRepository;
import com.example.mercadolivre.produto.pergunta.PerguntaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("detalhes")
public class DetalheSiteController {

    private ProdutoRepository produtorepository;
    private FotoRepository fotoRepository;
    private OpiniaoRepository opiniaoRepository;
    private PerguntaRepository perguntaRepository;


    public DetalheSiteController(ProdutoRepository produtorepository,
                                 FotoRepository fotoRepository,
                                 OpiniaoRepository opiniaoRepository,
                                 PerguntaRepository perguntaRepository) {

        this.produtorepository = produtorepository;
        this.fotoRepository = fotoRepository;
        this.opiniaoRepository = opiniaoRepository;
        this.perguntaRepository = perguntaRepository;
    }

    @GetMapping("/{idProduto}") //URL: algumacoisa/detalhes/1
        public DetalheSiteResponse sendEmail(@PathVariable Long idProduto){


        DetalheSiteResponse detalheSiteResponse = new DetalheSiteResponse();

        return detalheSiteResponse.pegarDados(produtorepository,
                                                idProduto,
                                                fotoRepository,
                                                opiniaoRepository,
                                                perguntaRepository);




   }

}
