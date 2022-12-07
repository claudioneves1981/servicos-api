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
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="TB_CLIENTE")
@GenericGenerator(
        name="SEQ_CLIENTE",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name="sequence_name",value="SEQ_CLIENTE"),
                @Parameter(name = "initial_value",value="1"),
                @Parameter(name = "increment_size",value="1")
        }
)
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SEQ_CLIENTE")
    @Column(name="CLI_ID")
    private Long ID;

    @Column(name="CLI_NOME_DA_EMPRESA")
    private String nomeDaEmpresa;

    @Column(name="CLI_NOMECONTATO")
    private String nomeContato;

    @Column(name="CLI_SOBRENOMECONTATO")
    private String sobrenomeContato;

    @Column(name="CLI_CONTATO_EMAIL")
    private String email;

    @Column(name="CLI_ENDERECOCOBRANCA")
    private String enderecoCobranca;

    @Column(name="CLI_CIDADE")
    private String cidade;

    @ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name = "TB_UF_CLIENTE",
            joinColumns = @JoinColumn(name="CLI_ID",
                    referencedColumnName = "CLI_ID"),
            inverseJoinColumns = @JoinColumn(name = "UF_ID",
                    referencedColumnName ="UF_ID")
    )
    private UfEntity ufID;

    @Column(name="CLI_CEP")
    private String CEP;

    @Column(name="CLI_PAIS_REGIAO")
    private String paisRegiao;

    @Column(name="CLI_TITULO_CONTATO")
    private String tituloContato;

    @Column(name="CLI_TELEFONE")
    private String telefone;

    @Column(name="CLI_FAX")
    private String fax;

    @Column(name="CLI_OBSERVACAO")
    private String observacao;

    @Column(name="CLI_DATA_DE_CADASTRO")
    private Date dataDeCadastro;
}

