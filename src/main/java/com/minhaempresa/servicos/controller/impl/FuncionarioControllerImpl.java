package com.minhaempresa.servicos.controller.impl;

import com.minhaempresa.servicos.controller.FuncionarioController;
import com.minhaempresa.servicos.dto.FuncionarioDTO;
import com.minhaempresa.servicos.exception.FuncionarioAlreadyRegistredException;
import com.minhaempresa.servicos.exception.FuncionarioNotFoundException;
import com.minhaempresa.servicos.services.FuncionarioService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Funcionario")
@Data
public final class FuncionarioControllerImpl implements FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioControllerImpl(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public FuncionarioDTO createFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO) throws FuncionarioAlreadyRegistredException {
        return funcionarioService.createFuncionario(funcionarioDTO);
    }

    @GetMapping("/{id}")
    @Override
    public FuncionarioDTO findById(@PathVariable Long id) throws FuncionarioNotFoundException {
        return funcionarioService.findById(id);
    }

    @GetMapping
    @Override
    public List<FuncionarioDTO> listFuncionarios() {
        return funcionarioService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deleteById(@PathVariable Long id) throws FuncionarioNotFoundException {
        funcionarioService.deleteById(id);
    }

}
