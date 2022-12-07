package com.minhaempresa.servicos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProdutoAlreadyRegistredException extends Exception {

    public ProdutoAlreadyRegistredException(String name){
        super(String.format("Produto with name %s not found in the system.", name));
    }

}