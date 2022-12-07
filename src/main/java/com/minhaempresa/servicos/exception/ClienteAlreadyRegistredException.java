package com.minhaempresa.servicos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClienteAlreadyRegistredException extends Exception {

    public ClienteAlreadyRegistredException(String name){
        super(String.format("Cliente with name %s not found in the system.", name));
    }

}
