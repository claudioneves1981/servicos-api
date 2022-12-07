package com.minhaempresa.servicos.controller;

import com.minhaempresa.servicos.dto.ProdutoDTO;
import com.minhaempresa.servicos.exception.ProdutoAlreadyRegistredException;
import com.minhaempresa.servicos.exception.ProdutoNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Manages Produto stock")
public interface ProdutoController {

    @ApiOperation(value = "Produto creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success Produto creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    ProdutoDTO createProduto(ProdutoDTO produtoDTO) throws ProdutoAlreadyRegistredException;

    @ApiOperation(value = "Returns Produto found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Produto found in the system"),
            @ApiResponse(code = 404, message = "Produto with given name not found.")
    })
    ProdutoDTO findById(@PathVariable Long id) throws ProdutoNotFoundException;

    @ApiOperation(value = "Returns a list of all Produtos registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all Produtos registered in the system"),
    })
    List<ProdutoDTO> listProdutos();

    @ApiOperation(value = "Delete a Produto found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success Produto deleted in the system"),
            @ApiResponse(code = 404, message = "Produto with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws ProdutoNotFoundException;
}
