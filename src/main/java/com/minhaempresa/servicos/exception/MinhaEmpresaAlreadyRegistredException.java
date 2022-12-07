package com.minhaempresa.servicos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MinhaEmpresaAlreadyRegistredException extends Exception {

    public MinhaEmpresaAlreadyRegistredException(String name){
        super(String.format("MinhaEmpresa with name %s not found in the system.", name));
    }

}