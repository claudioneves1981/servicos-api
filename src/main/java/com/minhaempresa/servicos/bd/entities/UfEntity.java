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
@Table(name="TB_UF")
@GenericGenerator(
        name="SEQ_UF",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name="sequence_name",value="SEQ_UF"),
                @Parameter(name = "initial_value",value="1"),
                @Parameter(name = "increment_size",value="1")
        }
)
public class UfEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SEQ_UF")
    @Column(name = "UF_ID")
    private Long ufID;

    @Column(name = "UF_SIGLA", unique = true)
    private String sigla;

    @Column(name = "UF_DESCRICAO")
    private String descricao;
}
