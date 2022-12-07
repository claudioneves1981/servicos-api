package com.minhaempresa.servicos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProdutoNotFoundException extends Exception{

    public ProdutoNotFoundException(Long id){
        super(String.format("Produto with id %s not found in the system.", id));
    }
}