package com.minhaempresa.servicos.controller;

import com.minhaempresa.servicos.dto.MinhaEmpresaDTO;
import com.minhaempresa.servicos.exception.MinhaEmpresaAlreadyRegistredException;
import com.minhaempresa.servicos.exception.MinhaEmpresaNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Manages MinhaEmpresa stock")
public interface MinhaEmpresaController {

    @ApiOperation(value = "MinhaEmpresa creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success MinhaEmpresa creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    MinhaEmpresaDTO createMinhaEmpresa(MinhaEmpresaDTO minhaEmpresaDTO) throws MinhaEmpresaAlreadyRegistredException;

    @ApiOperation(value = "Returns MinhaEmpresa found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success MinhaEmpresa found in the system"),
            @ApiResponse(code = 404, message = "MinhaEmpresa with given name not found.")
    })
    MinhaEmpresaDTO findById(@PathVariable Long id) throws MinhaEmpresaNotFoundException;

    @ApiOperation(value = "Returns a list of all MinhaEmpresas registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all MinhaEmpresas registered in the system"),
    })
    List<MinhaEmpresaDTO> listMinhaEmpresas();

    @ApiOperation(value = "Delete a MinhaEmpresa found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success MinhaEmpresa deleted in the system"),
            @ApiResponse(code = 404, message = "MinhaEmpresa with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws MinhaEmpresaNotFoundException;
}
