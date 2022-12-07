package com.minhaempresa.servicos.services.impl;

import com.minhaempresa.servicos.bd.entities.ProdutoEntity;
import com.minhaempresa.servicos.dto.ProdutoDTO;
import com.minhaempresa.servicos.exception.ProdutoAlreadyRegistredException;
import com.minhaempresa.servicos.exception.ProdutoNotFoundException;
import com.minhaempresa.servicos.adapter.ProdutoAdapter;
import com.minhaempresa.servicos.repository.ProdutoRepository;
import com.minhaempresa.servicos.services.ProdutoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoDTO createProduto(ProdutoDTO produtoDTO) throws ProdutoAlreadyRegistredException {
        verifyIfIsAlreadyRegistred(produtoDTO.getNomeDoProduto());
        ProdutoEntity produto = new ProdutoAdapter(produtoDTO).getProdutoEntity();
        ProdutoEntity savedProduto = produtoRepository.save(produto);
        return new ProdutoAdapter(savedProduto).getProdutoDTO();
    }

    @Override
    public ProdutoDTO findById(Long id) throws ProdutoNotFoundException{
        ProdutoEntity foundProduto = verifyIfExists(id);
        return new ProdutoAdapter(foundProduto).getProdutoDTO();
    }

    @Override
    public List<ProdutoDTO> listAll(){
        return new ProdutoAdapter(produtoRepository.findAll()).getProdutoDTOList();
    }

    @Override
    public void deleteById(Long id) throws ProdutoNotFoundException {
        verifyIfExists(id);
        produtoRepository.deleteById(id);
    }

    private ProdutoEntity verifyIfExists(Long id) throws ProdutoNotFoundException{
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));
    }

    private void verifyIfIsAlreadyRegistred(String name) throws ProdutoAlreadyRegistredException {
        Optional<ProdutoEntity> optSavedBeer = produtoRepository.findByProduto(name);
        if(optSavedBeer.isPresent()){
            throw new ProdutoAlreadyRegistredException(name);
        }
    }
}