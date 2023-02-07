package com.br.simulacao.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "simulacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimulacaoEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    @Setter(AccessLevel.NONE)
    private UUID id;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "pessoa_identificacao")
    private PessoaEntity pessoa;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    @Column(name = "valor_entrada")
    private Double valorEntrada;

    @Column(name = "valor_prestacao")
    private Double valorPrestacao;

    @Column(name = "quantidade_prestacoes")
    private Integer quantidadePrestacoes;

    @Column(name = "valor_total_contrato")
    private Double valorTotalContrato;

    @Column(name = "taxa_mensal")
    private Double taxaMensal;

    @Column(name = "taxa_anual")
    private Double taxaAnual;
}
