package com.minhaempresa.servicos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FuncionarioNotFoundException extends Exception{

    public FuncionarioNotFoundException(Long id){
        super(String.format("Funcionario with id %s not found in the system.", id));
    }
}

