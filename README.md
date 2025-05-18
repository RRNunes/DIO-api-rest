# Publicando Sua API REST na Nuvem Usando Spring Boot 3, Java 17 e Railway

### Entendendo o Desafio

Agora é a sua hora de brilhar e construir um perfil de destaque na DIO! Explore todos os conceitos explorados até aqui e replique (ou melhore, porque não?) este projeto prático. Para isso, crie seu próprio repositório e aumente ainda mais seu portfólio de projetos no GitHub, o qual pode fazer toda diferença em suas entrevistas técnicas 😎

Já dominamos o universo do desenvolvimento e construímos uma API REST utilizando o Java 17, a versão LTS mais recente repleta de novidades. Com o poder do Spring Boot 3, otimizamos nossa produtividade graças à sua habilidade de autoconfiguração. Além disso, facilitamos o acesso aos bancos de dados SQL com o auxílio do Spring Data JPA. Também destacamos a importância de uma documentação de API robusta e clara, utilizando o OpenAPI, ou Swagger. E com o Railway, simplificamos o Deploy de nossas soluções na nuvem. Agora, é hora de embarcar em um novo desafio e explorar um domínio de aplicação diferente, mantendo nosso foco em inovar e desenvolver soluções de alto padrão!

### Repositórios Git
O Git é um conceito essencial no mercado de trabalho atualmente, por isso sempre reforçamos sua importância em nossa metodologia educacional. Por isso, todo código-fonte desenvolvido durante este conteúdo foi versionado usando :

github.com/falvojr/santander-dev-week-2023: Repositório com todo o código-fonte desenvolvido neste Desafio de Projeto (Lab);

github.com/digitalinnovationone/santander-dev-week-2023-api: Aqui você tem acesso a uma versão mais robusta desta mesma API, com melhorias e padrões adicionais implementados. Se quiser se desafiar e buscar uma referência mais completa, este é o caminho!

Bons estudos 😉

# Meu projeto

Decidi criar minha própria aplicação API-REST, não replicar o exemplo dado em aula, melhorar inventário de produtos que criei para o desafio anterior aplicando tudo o que foi sugerido em aula para uma aplicação mais robusta, documentada com UML e Swagger, publicada na nuvem usando Railway e PostgreSQL e também utilizei Docker.
Se precisar de mais detalhes em qualquer uma das etapas, sinta-se à vontade para perguntar!

#### Deploy:
https://dio-api-rest.up.railway.app/swagger-ui/index.html

![Texto Alternativo](1721674207596.jpg)

## Diagrama de classes 

````  mermaid
classDiagram
    class Produto {
        Long id
        String nome
        Double preco
        Integer quantidade
        String descricao
    }

    class ProdutoRepository {
        <<interface>>
        +List~Produto~ findAll()
        +Optional~Produto~ findById(Long id)
        +Produto save(Produto produto)
        +void deleteById(Long id)
    }

    class ProdutoService {
        +List~Produto~ findAll()
        +Optional~Produto~ findById(Long id)
        +Produto save(Produto produto)
        +void deleteById(Long id)
    }

    class ProdutoController {
        +List~Produto~ getAllProdutos()
        +ResponseEntity~Produto~ getProdutoById(Long id)
        +Produto createProduto(Produto produto)
        +ResponseEntity~Produto~ updateProduto(Long id, Produto produto)
        +ResponseEntity~Void~ deleteProduto(Long id)
    }

    Produto --> ProdutoRepository
    ProdutoRepository --> ProdutoService
    ProdutoService --> ProdutoController
```
