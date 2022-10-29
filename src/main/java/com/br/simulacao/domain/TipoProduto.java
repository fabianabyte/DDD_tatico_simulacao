package com.br.simulacao.domain;

import lombok.Getter;

@Getter
public enum TipoProduto {
    VEICULO("Veículo", 1),
    IMOVEL("Imóvel", 2),
    EMPRESIMO("Empréstimo", 3);

    private String descricao;
    private Integer id;
    private TipoProduto(String descricao, Integer id){
            this.descricao = descricao;
            this.id = id;
    }
}
