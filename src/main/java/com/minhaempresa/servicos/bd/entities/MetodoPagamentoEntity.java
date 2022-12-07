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
@Table(name="TB_METODO_PGTO")
@GenericGenerator(
        name="SEQ_METODO_PGTO",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name="sequence_name",value="SEQ_METODO_PGTO"),
                @Parameter(name = "initial_value",value="1"),
                @Parameter(name = "increment_size",value="1")
        }
)
public class MetodoPagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SEQ_METODO_PGTO")
    @Column(name="MPG_ID")
    private Long metodoPagamentoID;

    @Column(name="MPG_METODO_PGTO")
    private String metodoPagamento;

    @Column(name="MPG_CARTAO_CREDITO")
    private Boolean cartaoCredito;
}
