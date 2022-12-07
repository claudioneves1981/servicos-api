package com.minhaempresa.servicos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetodoPagamentoDTO {

    private Long metodoPagamentoID;

    @Size(max = 50)
    private String metodoPagamento;

    private Boolean cartaoCredito;

}
