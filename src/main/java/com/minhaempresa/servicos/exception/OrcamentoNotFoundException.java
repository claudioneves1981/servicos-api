package com.minhaempresa.servicos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrcamentoNotFoundException extends Exception{

    public OrcamentoNotFoundException(Long id){
        super(String.format("Orcamento with id %s not found in the system.", id));
    }
}
