package com.minhaempresa.servicos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrcamentoDTO {

    private Long orcID;
    private ClienteDTO clienteID;
    private FuncionarioDTO funcionarioID;
    private ProdutoDTO prdID;

    private Date dataRecebimento;
    private Date dataRequerida;

    @Size(max = 50)
    private String marcaModelo;

    @Size(max = 50)
    private String modelo;

    private String descricaoProbl;

    private Date dataTermino;
    private Date dataColheita;

    @Min(0)
    @Max(100)
    private Double aliquotaISS;

    private Double valor;
    private Date dataPgto;
    private Double quantidade;

    private MetodoPagamentoDTO mpgDTO;


}
