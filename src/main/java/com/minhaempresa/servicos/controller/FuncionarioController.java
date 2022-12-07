package com.minhaempresa.servicos.controller;

import com.minhaempresa.servicos.dto.FuncionarioDTO;
import com.minhaempresa.servicos.exception.FuncionarioAlreadyRegistredException;
import com.minhaempresa.servicos.exception.FuncionarioNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Manages Funcionario stock")
public interface FuncionarioController {

    @ApiOperation(value = "Funcionario creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success Funcionario creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    FuncionarioDTO createFuncionario(FuncionarioDTO funcionarioDTO) throws FuncionarioAlreadyRegistredException;

    @ApiOperation(value = "Returns Funcionario found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Funcionario found in the system"),
            @ApiResponse(code = 404, message = "Funcionario with given name not found.")
    })
    FuncionarioDTO findById(@PathVariable Long id) throws FuncionarioNotFoundException;

    @ApiOperation(value = "Returns a list of all Funcionarios registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all Funcionarios registered in the system"),
    })
    List<FuncionarioDTO> listFuncionarios();

    @ApiOperation(value = "Delete a Funcionario found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success Funcionario deleted in the system"),
            @ApiResponse(code = 404, message = "Funcionario with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws FuncionarioNotFoundException;
}
