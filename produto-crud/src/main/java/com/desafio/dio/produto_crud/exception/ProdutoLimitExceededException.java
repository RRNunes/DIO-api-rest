package com.desafio.dio.produto_crud.exception;

public class ProdutoLimitExceededException extends RuntimeException {
    public ProdutoLimitExceededException(String message) {
        super(message);
    }

}
