package com.minhaempresa.servicos.bd.entities;

import com.minhaempresa.servicos.dto.MetodoPagamentoDTO;
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
@Table(name="TB_ORCAMENTO")
@GenericGenerator(
        name="SEQ_ORCAMENTO",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name="sequence_name",value="SEQ_ORCAMENTO"),
                @Parameter(name = "initial_value",value="1"),
                @Parameter(name = "increment_size",value="1")
        }
)
public class OrcamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SEQ_ORCAMENTO")
    @Column(name = "ORC_ID")
    private Long orcID;

    @ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name = "TB_PRODUTO_ORC",
            joinColumns = @JoinColumn(name="ORC_ID",
                    referencedColumnName = "ORC_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRD_ID",
                    referencedColumnName ="PRD_ID")
    )
    private ProdutoEntity prdID;

    @ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name = "TB_CLIENTE_ORC",
            joinColumns = @JoinColumn(name="ORC_ID",
                    referencedColumnName = "ORC_ID"),
            inverseJoinColumns = @JoinColumn(name = "CLI_ID",
                    referencedColumnName ="CLI_ID")
    )
    private ClienteEntity clienteID;

    @ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name = "TB_FUNCIONARIO_ORC",
            joinColumns = @JoinColumn(name="ORC_ID",
                    referencedColumnName = "ORC_ID"),
            inverseJoinColumns = @JoinColumn(name = "FUN_ID",
                    referencedColumnName ="FUN_ID")
    )
    private FuncionarioEntity funcionarioID;

    @Column(name = "ORC_DATA_RECEBIMENTO")
    private Date dataRecebimento;

    @Column(name = "ORC_DATA_REQUERIDA")
    private Date dataRequerida;

    @Column(name = "ORC_MARCA_MODELO")
    private String marcaModelo;

    @Column(name = "ORC_MODELO")
    private String modelo;

    @Column(name = "ORC_DESCRICAO_PROBL")
    private String descricaoProbl;

    @Column(name = "ORC_DATA_TERMINO")
    private Date dataTermino;

    @Column(name = "ORC_DATA_COLHEITA")
    private Date dataColheita;

    @Column(name = "ORC_ALIQUOTA_ISS")
    private Double aliquotaISS;

    private Double valor;
    private Date dataPgto;
    private Double quantidade;

    @ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name = "TB_METODO_PGTO_ORC",
            joinColumns = @JoinColumn(name="ORC_ID",
                    referencedColumnName = "ORC_ID"),
            inverseJoinColumns = @JoinColumn(name = "MPG_ID",
                    referencedColumnName ="MPG_ID")
    )
    private MetodoPagamentoEntity mpgID;
}
