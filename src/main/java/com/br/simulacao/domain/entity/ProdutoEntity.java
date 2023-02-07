package com.br.simulacao.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name = "descricao")
    private String descricao;

}
