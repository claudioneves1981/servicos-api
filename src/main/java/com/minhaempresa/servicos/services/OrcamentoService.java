package com.minhaempresa.servicos.services;

import com.minhaempresa.servicos.dto.OrcamentoDTO;
import com.minhaempresa.servicos.exception.OrcamentoAlreadyRegistredException;
import com.minhaempresa.servicos.exception.OrcamentoNotFoundException;

import java.util.List;

public interface OrcamentoService {

    OrcamentoDTO createOrcamento(OrcamentoDTO orcamentoDTO) throws OrcamentoNotFoundException, OrcamentoAlreadyRegistredException;
    OrcamentoDTO findById(Long id) throws OrcamentoNotFoundException;
    List<OrcamentoDTO> listAll();
    void deleteById(Long id) throws OrcamentoNotFoundException;
}
