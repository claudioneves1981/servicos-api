package com.minhaempresa.servicos.services;

import com.minhaempresa.servicos.dto.ClienteDTO;
import com.minhaempresa.servicos.exception.ClienteAlreadyRegistredException;
import com.minhaempresa.servicos.exception.ClienteNotFoundException;

import java.util.List;

public interface ClienteService {

    ClienteDTO createCliente(ClienteDTO clienteDTO) throws ClienteAlreadyRegistredException;
    ClienteDTO findById(Long id) throws ClienteNotFoundException;
    List<ClienteDTO> listAll();
    void deleteById(Long id) throws ClienteNotFoundException;
}
