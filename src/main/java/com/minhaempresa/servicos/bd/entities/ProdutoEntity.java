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
@Table(name="TB_PRODUTO")
@GenericGenerator(
        name="SEQ_PRODUTO",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name="sequence_name",value="SEQ_PRODUTO"),
                @Parameter(name = "initial_value",value="1"),
                @Parameter(name = "increment_size",value="1")
        }
)
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SEQ_PRODUTO")
    @Column(name="PRD_ID")
    private Long prdID;

    @Column(name="PRD_PRODUTO")
    private String produto;

    @Column(name="PRD_PRECOUNITARIO")
    private Double precoUnitario;

    @Column(name="PRD_DESCRICAO_PARTE")
    private String descricaoParte;

}
