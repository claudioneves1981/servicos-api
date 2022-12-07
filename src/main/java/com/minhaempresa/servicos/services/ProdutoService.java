package com.minhaempresa.servicos.services;

import com.minhaempresa.servicos.dto.ProdutoDTO;
import com.minhaempresa.servicos.exception.ProdutoAlreadyRegistredException;
import com.minhaempresa.servicos.exception.ProdutoNotFoundException;

import java.util.List;

public interface ProdutoService {

    ProdutoDTO createProduto(ProdutoDTO produtoDTO) throws ProdutoAlreadyRegistredException;
    ProdutoDTO findById(Long id) throws ProdutoNotFoundException;
    List<ProdutoDTO> listAll();
    void deleteById(Long id) throws ProdutoNotFoundException;

}
