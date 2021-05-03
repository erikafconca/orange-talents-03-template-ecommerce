package com.example.mercadolivre.produto.foto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FotoRepository extends JpaRepository<Foto, Long> {

    List<Foto> findByProdutoId(Long idProduto);
}
