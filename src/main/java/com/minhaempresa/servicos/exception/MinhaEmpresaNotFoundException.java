package com.minhaempresa.servicos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MinhaEmpresaNotFoundException extends Exception{

    public MinhaEmpresaNotFoundException(Long id){
        super(String.format("MinhaEmpresa with id %s not found in the system.", id));
    }
}