package com.minhaempresa.servicos.controller.impl;

import com.minhaempresa.servicos.controller.ProdutoController;
import com.minhaempresa.servicos.dto.ProdutoDTO;
import com.minhaempresa.servicos.exception.ProdutoAlreadyRegistredException;
import com.minhaempresa.servicos.exception.ProdutoNotFoundException;
import com.minhaempresa.servicos.services.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Produto")
@Data
public final class ProdutoControllerImpl implements ProdutoController {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoControllerImpl(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ProdutoDTO createProduto(@RequestBody @Valid ProdutoDTO produtoDTO) throws ProdutoAlreadyRegistredException {
        return produtoService.createProduto(produtoDTO);
    }

    @GetMapping("/{id}")
    @Override
    public ProdutoDTO findById(@PathVariable Long id) throws ProdutoNotFoundException {
        return produtoService.findById(id);
    }

    @GetMapping
    @Override
    public List<ProdutoDTO> listProdutos() {
        return produtoService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deleteById(@PathVariable Long id) throws ProdutoNotFoundException {
        produtoService.deleteById(id);
    }

}

