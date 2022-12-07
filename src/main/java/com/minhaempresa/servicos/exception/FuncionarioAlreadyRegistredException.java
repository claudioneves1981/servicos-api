package com.minhaempresa.servicos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FuncionarioAlreadyRegistredException extends Exception {

    public FuncionarioAlreadyRegistredException(String name){
        super(String.format("Funcionario with name %s not found in the system.", name));
    }

}