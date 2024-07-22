package com.desafio.dio.produto_crud.service;

import com.desafio.dio.produto_crud.exception.ProdutoLimitExceededException;
import com.desafio.dio.produto_crud.exception.ProdutoNotFoundException;
import com.desafio.dio.produto_crud.model.Produto;
import com.desafio.dio.produto_crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    private static final int MAX_PRODUTOS = 10;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return Optional.ofNullable(produtoRepository.findById(id).orElseThrow(() -> new ProdutoNotFoundException(id)));
    }

    public Produto save(Produto produto) {
        long count = produtoRepository.countProduto();
        if (count >= MAX_PRODUTOS) {
            throw new ProdutoLimitExceededException("Limite máximo de produtos alcançado. Por favor, delete produtos para inserir novos.");
        }
        return produtoRepository.save(produto);
    }

    public void deleteById(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ProdutoNotFoundException(id);
        }
        produtoRepository.deleteById(id);
    }
}
