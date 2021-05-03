package com.example.mercadolivre.produto.paginadetalhe;

import com.example.mercadolivre.produto.Caracteristica;
import com.example.mercadolivre.produto.Produto;
import com.example.mercadolivre.produto.ProdutoRepository;
import com.example.mercadolivre.produto.foto.Foto;
import com.example.mercadolivre.produto.foto.FotoRepository;
import com.example.mercadolivre.produto.opiniao.Opiniao;
import com.example.mercadolivre.produto.opiniao.OpiniaoRepository;
import com.example.mercadolivre.produto.pergunta.Pergunta;
import com.example.mercadolivre.produto.pergunta.PerguntaRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class DetalheSiteResponse {

    private Integer soma = 0;

    private String nome;
    private BigDecimal preco;
    private String descricao;

    private List<String> fotos = new ArrayList<>();

    private List<String> caracteristicas = new ArrayList<>();

    private List<OpiniaoResponse> opinioes = new ArrayList<>();

    private Integer qtNotas;
    private Double media;

    private List<String> perguntas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public List<OpiniaoResponse> getOpinioes() {
        return opinioes;
    }

    public Integer getQtNotas() {
        return qtNotas;
    }

    public Double getMedia() {
        return media;
    }

    public List<String> getPerguntas() {
        return perguntas;
    }

    public DetalheSiteResponse pegarDados(
            ProdutoRepository produtoRepository,
            Long idproduto,
            FotoRepository fotoRepository,
            OpiniaoRepository opiniaoRepository,
            PerguntaRepository perguntaRepository){

        Optional<Produto> produtoOptional = produtoRepository.findById(idproduto);

        if(produtoOptional.isPresent()){
            this.nome = produtoOptional.get().getNome();
            this.preco = produtoOptional.get().getValor();
            this.descricao = produtoOptional.get().getDescricao();


            //fotos
            List<Foto> listaFotos = fotoRepository.findByProdutoId(idproduto);

            listaFotos.stream()
                    .map(e->this.fotos.add(e.getLinkImagem()))
                    .collect(Collectors.toList());


            //opiniao
            List<Opiniao> opinioes = opiniaoRepository.findByUsuarioId(idproduto);

            this.opinioes = opinioes.stream()
                    .map(e->{
                        this.soma += e.getNota();
                        return new OpiniaoResponse(e.getNota(),e.getTitulo(),e.getDescricao());
                    })
                    .collect(Collectors.toList());

            this.qtNotas = opinioes.size();
            this.media =  ((double)soma/(double)qtNotas);


            //pergunta

            List<Pergunta> perguntas = perguntaRepository.findByProdutoId(idproduto);

            System.out.println("ARRAY PERGUNTAS : " + perguntas);


            if(!perguntas.isEmpty()){
                perguntas.stream()
                        .map(e->this.perguntas.add(e.getPergunta()))
                        .collect(Collectors.toList());
            }



            List<Caracteristica> novalista = produtoOptional.get().getCaracteristicas();


            novalista
                    .stream()
                    .map(e-> this.caracteristicas.add("Nome: " + e.getNome() + " Descrição :" + e.getDescricao()))
                    .collect(Collectors.toList());


//            for(int i = 0; i<fotos.size(); i++){
//                this.fotos.add(fotos.get(i).getLinkImagem());
//            }




        }

        return this;

    }



}

