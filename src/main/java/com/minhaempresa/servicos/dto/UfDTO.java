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
public class UfDTO {

    private Long ufID;

    @Size(max = 2)
    private String sigla;

    private String descricao;
}
