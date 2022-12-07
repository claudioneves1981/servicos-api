package com.minhaempresa.servicos.controller;

import com.minhaempresa.servicos.dto.ClienteDTO;
import com.minhaempresa.servicos.exception.ClienteAlreadyRegistredException;
import com.minhaempresa.servicos.exception.ClienteNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Manages Cliente stock")
public interface ClienteController {

    @ApiOperation(value = "Cliente creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success Cliente creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    ClienteDTO createCliente(ClienteDTO clienteDTO) throws ClienteAlreadyRegistredException;

    @ApiOperation(value = "Returns Cliente found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Cliente found in the system"),
            @ApiResponse(code = 404, message = "Cliente with given name not found.")
    })
    ClienteDTO findById(@PathVariable Long id) throws ClienteNotFoundException;

    @ApiOperation(value = "Returns a list of all Clientes registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all Clientes registered in the system"),
    })
    List<ClienteDTO> listClientes();

    @ApiOperation(value = "Delete a Cliente found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success Cliente deleted in the system"),
            @ApiResponse(code = 404, message = "Cliente with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws ClienteNotFoundException;
}