package com.minhaempresa.servicos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MinhaEmpresaDTO {

    private Long minhaEmpresaID;

    @Min(0)
    @Max(100)
    private Double aliquotaImpostoServico;

    @Size(max = 50)
    private String nomeEmpresa;

    @Size(max = 255)
    private String endereco;

    @Size(max = 50)
    private String cidade;

    private UfDTO ufID;

    @Size(max = 10)
    private String CEP;

    @Size(max = 50)
    private String paisRegiao;

    @Size(max = 30)
    private String telefone;

    @Size(max = 30)
    private String fax;

    @Size(max = 255)
    private String termoPgtoPadrao;

    private String descricaoFaturaPadrao;
}
