package com.minhaempresa.servicos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDTO {

    private Long prodID;
    private String nomeDoProduto;
    private Double precoUnitario;
    private String descricaoParte;

}
