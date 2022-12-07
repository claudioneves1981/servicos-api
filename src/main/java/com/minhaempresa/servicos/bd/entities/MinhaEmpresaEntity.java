package com.minhaempresa.servicos.bd.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="TB_MINHA_EMPRESA")
@GenericGenerator(
        name="SEQ_MINHA_EMPRESA",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name="sequence_name",value="SEQ_MINHA_EMPRESA"),
                @Parameter(name = "initial_value",value="1"),
                @Parameter(name = "increment_size",value="1")
        }
)
public class MinhaEmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SEQ_MINHA_EMPRESA")
    @Column(name="MEM_ID")
    private Long minhaEmpresaID;

    @Column(name="MEM_ALIQUOTA_IMPOSTO_SERVICO")
    private Double aliquotaImpostoServico;

    @Column(name="MEM_NOME_EMPRESA")
    private String nomeEmpresa;

    @Column(name="MEM_ENDERECO")
    private String endereco;

    @Column(name="MEM_CIDADE")
    private String cidade;

    @ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name = "TB_UF_MEM",
            joinColumns = @JoinColumn(name="MEM_ID",
                    referencedColumnName = "MEM_ID"),
            inverseJoinColumns = @JoinColumn(name = "UF_ID",
                    referencedColumnName ="UF_ID")
    )
    private UfEntity ufID;

    @Column(name="MEM_CEP")
    private String CEP;

    @Column(name="MEM_PAIS_REGIAO")
    private String paisRegiao;

    @Column(name="MEM_TELEFONE")
    private String telefone;

    @Column(name="MEM_FAX")
    private String fax;

    @Column(name="MEM_TERMO_PGTO_PADRAO")
    private String termoPgtoPadrao;

    @Column(name="MEM_DESCRICAO_FATURA_PADRAO")
    private String descricaoFaturaPadrao;

}
