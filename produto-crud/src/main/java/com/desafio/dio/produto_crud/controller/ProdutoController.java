package com.desafio.dio.produto_crud.controller;

import com.desafio.dio.produto_crud.exception.ProdutoNotFoundException;
import com.desafio.dio.produto_crud.model.Produto;
import com.desafio.dio.produto_crud.service.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@Tag(name = "Produto", description = "API de Inventário de Produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @Operation(summary = "Listar todos os produtos")
    public List<Produto> getAllProduto() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter produto por ID")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        return produtoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo produto")
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um produto existente")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
        if (!produtoService.findById(id).isPresent()) {
            throw new ProdutoNotFoundException(id);
        }
        produto.setId(id);
        return ResponseEntity.ok(produtoService.save(produto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um produto por ID")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}