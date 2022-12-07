package com.minhaempresa.servicos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends Exception{

    public ClienteNotFoundException(Long id){
        super(String.format("Cliente with id %s not found in the system.", id));
    }
}
