package com.br.simulacao.domain.entidade.simulacao;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name = "nomeProduto")
    private String nomeProduto;

    @Column(name = "tipoProduto")
    private String tipoProduto;

}
