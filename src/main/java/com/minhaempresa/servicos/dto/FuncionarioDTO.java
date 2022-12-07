package com.minhaempresa.servicos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionarioDTO {

    private Long funcId;

    @Size(max = 50)
    private String nome;

    @Size(max = 50)
    private String sobrenome;

    @Size(max = 50)
    private String cargo;

    @Size(max = 50)
    private String nomeEmail;

    @Size(max = 5)
    private String ramal;

    @Size(max = 30)
    private String telefoneComercial;

    private Double taxaCobranca;

    @Size(max = 20)
    private String escritorio;

    private Date dataCadastro;

}
