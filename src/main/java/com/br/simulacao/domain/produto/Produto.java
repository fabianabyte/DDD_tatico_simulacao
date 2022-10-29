package com.br.simulacao.domain.produto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Produto {
    private String nome;
    private TipoProduto tipoProduto;
}
