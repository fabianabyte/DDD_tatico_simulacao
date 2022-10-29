package com.br.simulacao.domain;

import com.br.simulacao.domain.pessoa.Pessoa;
import com.br.simulacao.domain.produto.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Simulacao {
    private Pessoa pessoa;
    private Produto produto;
    private Double valorEntrada;
    private Double valorPrestacao;
    private Integer quantidadePrestacoes;
    private Double valorTotalContrato;
    private Double taxaMensal;
    private Double taxaAnual;
}
