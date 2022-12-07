package com.minhaempresa.servicos.controller;

import com.minhaempresa.servicos.dto.OrcamentoDTO;
import com.minhaempresa.servicos.exception.OrcamentoAlreadyRegistredException;
import com.minhaempresa.servicos.exception.OrcamentoNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Manages Orcamento stock")
public interface OrcamentoController {

    @ApiOperation(value = "Orcamento creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success Orcamento creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    OrcamentoDTO createOrcamento(OrcamentoDTO orcamentoDTO) throws OrcamentoNotFoundException, OrcamentoAlreadyRegistredException;

    @ApiOperation(value = "Returns Orcamento found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Orcamento found in the system"),
            @ApiResponse(code = 404, message = "Orcamento with given name not found.")
    })
    OrcamentoDTO findById(@PathVariable Long id) throws OrcamentoNotFoundException;

    @ApiOperation(value = "Returns a list of all Orcamentos registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all Orcamentos registered in the system"),
    })
    List<OrcamentoDTO> listOrcamentos();

    @ApiOperation(value = "Delete a Orcamento found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success Orcamento deleted in the system"),
            @ApiResponse(code = 404, message = "Orcamento with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws OrcamentoNotFoundException;
}
