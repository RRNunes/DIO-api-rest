## Diagrama de classes 

````  mermaid
classDiagram
    class Produto {
        + Long id
        + String nome
        + Double preco
        + Integer quantidade
        + String descricao
    }

    class ProdutoRepository {
        + List<Produto> findAll()
        + Optional<Produto> findById(Long id)
        + Produto save(Produto produto)
        + void deleteById(Long id)
    }

    class ProdutoService {
        - ProdutoRepository produtoRepository
        + List<Produto> findAll()
        + Optional<Produto> findById(Long id)
        + Produto save(Produto produto)
        + void deleteById(Long id)
    }

    class ProdutoController {
        - ProdutoService produtoService
        + List<Produto> getAllProdutos()
        + ResponseEntity<Produto> getProdutoById(Long id)
        + Produto createProduto(Produto produto)
        + ResponseEntity<Produto> updateProduto(Long id, Produto produto)
        + ResponseEntity<Void> deleteProduto(Long id)
    }

    Produto <-- ProdutoRepository
    ProdutoRepository <-- ProdutoService
    ProdutoService --> ProdutoController

```
