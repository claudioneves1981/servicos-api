package com.minhaempresa.servicos.controller.impl;

import com.minhaempresa.servicos.controller.OrcamentoController;
import com.minhaempresa.servicos.dto.OrcamentoDTO;
import com.minhaempresa.servicos.exception.OrcamentoAlreadyRegistredException;
import com.minhaempresa.servicos.exception.OrcamentoNotFoundException;
import com.minhaempresa.servicos.services.OrcamentoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Orcamento")
@Data
public final class OrcamentoControllerImpl implements OrcamentoController {

    private final OrcamentoService orcamentoService;

    @Autowired
    public OrcamentoControllerImpl(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public OrcamentoDTO createOrcamento(@RequestBody @Valid OrcamentoDTO orcamentoDTO) throws OrcamentoNotFoundException, OrcamentoAlreadyRegistredException {
        return orcamentoService.createOrcamento(orcamentoDTO);
    }

    @GetMapping("/{id}")
    @Override
    public OrcamentoDTO findById(@PathVariable Long id) throws OrcamentoNotFoundException {
        return orcamentoService.findById(id);
    }


    @GetMapping
    @Override
    public List<OrcamentoDTO> listOrcamentos() {
        return orcamentoService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deleteById(@PathVariable Long id) throws OrcamentoNotFoundException {
        orcamentoService.deleteById(id);
    }
}

