package com.minhaempresa.servicos.bd.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="TB_FUNCIONARIO")
@GenericGenerator(
        name="SEQ_FUNCIONARIO",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name="sequence_name",value="SEQ_FUNCIONARIO"),
                @Parameter(name = "initial_value",value="1"),
                @Parameter(name = "increment_size",value="1")
        }
)
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SEQ_FUNCIONARIO")
    @Column(name="FUN_ID")
    private Long funcId;

    @Column(name="FUN_NOME")
    private String nome;

    @Column(name="FUN_SOBRENOME")
    private String sobrenome;

    @Column(name="FUN_CARGO")
    private String cargo;

    @Column(name="FUN_NOME_EMAIL")
    private String nomeEmail;

    @Column(name="FUN_RAMAL")
    private String ramal;

    @Column(name="FUN_TELEFONE_COMERCIAL")
    private String telefoneComercial;

    @Column(name="FUN_TAXA_COBRANCA")
    private Double taxaCobranca;

    @Column(name="FUN_ESCRITORIO")
    private String escritorio;

    @Column(name="FUN_DATA_CADASTRO")
    private Date dataCadastro;
}
