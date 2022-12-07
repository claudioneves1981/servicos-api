package com.minhaempresa.servicos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private Long ID;

    @Size(max = 255)
    private String nomeDaEmpresa;

    @NotBlank
    @Size(max = 50)
    private String nomeContato;

    @Size(max=50)
    private String sobrenomeContato;

    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(max = 255)
    private String enderecoCobranca;

    private String cidade;

    private UfDTO ufID;

    @Size(max = 10)
    private String CEP;

    @Size(max = 50)
    private String paisRegiao;

    @Size(max = 50)
    private String tituloContato;

    @Size(max = 50)
    private String telefone;

    @Size(max = 50)
    private String fax;

    private String observacao;

    private Date dataDeCadastro;
}
