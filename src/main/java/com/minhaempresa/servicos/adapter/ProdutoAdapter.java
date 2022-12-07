package com.minhaempresa.servicos.adapter;

import com.minhaempresa.servicos.bd.entities.ProdutoEntity;
import com.minhaempresa.servicos.dto.ProdutoDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProdutoAdapter {

    private ProdutoEntity produtoEntity;
    private ProdutoDTO produtoDTO;
    private List<ProdutoDTO> produtoDTOList;

    public ProdutoAdapter(ProdutoDTO produtoDTO) {
        produtoEntity = toModel(produtoDTO);
    }

    public ProdutoAdapter(ProdutoEntity produtoEntity) {
        produtoDTO = toDTO(produtoEntity);
    }

    public ProdutoAdapter(List<ProdutoEntity> produtoEntityList) {
        produtoDTOList = toDTOList(produtoEntityList);
    }

    private ProdutoDTO toDTO(ProdutoEntity produtoEntity) {
        
        return ProdutoDTO.builder()
                .prodID(produtoEntity.getPrdID())
                .descricaoParte(produtoEntity.getDescricaoParte())
                .precoUnitario(produtoEntity.getPrecoUnitario())
                .nomeDoProduto(produtoEntity.getProduto())
                .build();
    }

    private ProdutoEntity toModel(ProdutoDTO produtoDTO) {

        return ProdutoEntity.builder()
                .prdID(produtoDTO.getProdID())
                .descricaoParte(produtoDTO.getDescricaoParte())
                .precoUnitario(produtoDTO.getPrecoUnitario())
                .produto(produtoDTO.getNomeDoProduto())
                .build();
    }

    private List<ProdutoDTO> toDTOList(List<ProdutoEntity> produtoEntityList) {

        produtoDTOList = new ArrayList<>();
        for(ProdutoEntity produtoEntity : produtoEntityList){
            produtoDTOList.add(toDTO(produtoEntity));
        }
        return produtoDTOList;
    }


}
