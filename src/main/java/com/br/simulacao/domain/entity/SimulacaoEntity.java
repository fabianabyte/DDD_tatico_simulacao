package com.br.simulacao.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "simulacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimulacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int id;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "pessoaIdentificacao")
    private PessoaEntity pessoa;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "produtoId")
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
