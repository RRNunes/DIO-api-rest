package com.desafio.dio.produto_crud.repository;

import com.desafio.dio.produto_crud.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT COUNT(p) FROM Produto p")
    long countProduto();

}
