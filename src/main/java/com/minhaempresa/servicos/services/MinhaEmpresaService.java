package com.minhaempresa.servicos.services;

import com.minhaempresa.servicos.dto.MinhaEmpresaDTO;
import com.minhaempresa.servicos.exception.MinhaEmpresaAlreadyRegistredException;
import com.minhaempresa.servicos.exception.MinhaEmpresaNotFoundException;

import java.util.List;

public interface MinhaEmpresaService {

    MinhaEmpresaDTO createMinhaEmpresa(MinhaEmpresaDTO MinhaEmpresaDTO) throws MinhaEmpresaAlreadyRegistredException;
    MinhaEmpresaDTO findById(Long id) throws MinhaEmpresaNotFoundException;
    List<MinhaEmpresaDTO> listAll();
    void deleteById(Long id) throws MinhaEmpresaNotFoundException;

}
