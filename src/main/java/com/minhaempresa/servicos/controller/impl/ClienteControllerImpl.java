package com.minhaempresa.servicos.controller.impl;

import com.minhaempresa.servicos.controller.ClienteController;
import com.minhaempresa.servicos.dto.ClienteDTO;
import com.minhaempresa.servicos.exception.ClienteAlreadyRegistredException;
import com.minhaempresa.servicos.exception.ClienteNotFoundException;
import com.minhaempresa.servicos.services.ClienteService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Cliente")
@Data
public final class ClienteControllerImpl implements ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteControllerImpl(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ClienteDTO createCliente(@RequestBody @Valid ClienteDTO clienteDTO) throws ClienteAlreadyRegistredException {
        return clienteService.createCliente(clienteDTO);
    }

    @GetMapping("/{id}")
    @Override
    public ClienteDTO findById(@PathVariable Long id) throws ClienteNotFoundException {
        return clienteService.findById(id);
    }

    @GetMapping
    @Override
    public List<ClienteDTO> listClientes() {
        return clienteService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deleteById(@PathVariable Long id) throws ClienteNotFoundException {
        clienteService.deleteById(id);
    }

}