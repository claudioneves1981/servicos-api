package com.minhaempresa.servicos.services;

import com.minhaempresa.servicos.dto.FuncionarioDTO;
import com.minhaempresa.servicos.exception.FuncionarioAlreadyRegistredException;
import com.minhaempresa.servicos.exception.FuncionarioNotFoundException;

import java.util.List;

public interface FuncionarioService {

    FuncionarioDTO createFuncionario(FuncionarioDTO FuncionarioDTO) throws FuncionarioAlreadyRegistredException;
    FuncionarioDTO findById(Long id) throws FuncionarioNotFoundException;
    List<FuncionarioDTO> listAll();
    void deleteById(Long id) throws FuncionarioNotFoundException;

}
