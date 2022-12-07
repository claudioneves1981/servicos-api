package com.minhaempresa.servicos.controller.impl;

import com.minhaempresa.servicos.controller.MinhaEmpresaController;
import com.minhaempresa.servicos.dto.MinhaEmpresaDTO;
import com.minhaempresa.servicos.exception.MinhaEmpresaAlreadyRegistredException;
import com.minhaempresa.servicos.exception.MinhaEmpresaNotFoundException;
import com.minhaempresa.servicos.services.MinhaEmpresaService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/MinhaEmpresa")
@Data
public final class MinhaEmpresaControllerImpl implements MinhaEmpresaController {

    private final MinhaEmpresaService minhaEmpresaService;

    @Autowired
    public MinhaEmpresaControllerImpl(MinhaEmpresaService minhaEmpresaService) {
        this.minhaEmpresaService = minhaEmpresaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public MinhaEmpresaDTO createMinhaEmpresa(@RequestBody @Valid MinhaEmpresaDTO minhaEmpresaDTO) throws MinhaEmpresaAlreadyRegistredException {
        return minhaEmpresaService.createMinhaEmpresa(minhaEmpresaDTO);
    }

    @GetMapping("/{id}")
    @Override
    public MinhaEmpresaDTO findById(@PathVariable Long id) throws MinhaEmpresaNotFoundException {
        return minhaEmpresaService.findById(id);
    }

    @GetMapping
    @Override
    public List<MinhaEmpresaDTO> listMinhaEmpresas() {
        return minhaEmpresaService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deleteById(@PathVariable Long id) throws MinhaEmpresaNotFoundException {
        minhaEmpresaService.deleteById(id);
    }
}
