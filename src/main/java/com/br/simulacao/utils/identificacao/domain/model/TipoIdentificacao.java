package com.br.simulacao.utils.identificacao.domain.model;

import lombok.Getter;

import java.util.HashMap;

@Getter
public enum TipoIdentificacao {
    CNPJ("CNPJ", Integer.valueOf(14)),
    CPF("CPF", Integer.valueOf(11));

    private String descricao;
    private Integer tamanho;
    private static HashMap<String, TipoIdentificacao> lookup;

    private TipoIdentificacao(final String descricao, final Integer tamanho) {
        this.descricao = descricao;
        this.tamanho = tamanho;
    }

    private static HashMap<String, TipoIdentificacao> gerarLookUp() {
        final HashMap<String, TipoIdentificacao> retorno = new HashMap<String, TipoIdentificacao>();
        for (TipoIdentificacao tipoIdentificacao : values()) {
            retorno.put(tipoIdentificacao.getDescricao(), tipoIdentificacao);
        }
        return retorno;
    }

    public static TipoIdentificacao obterPorDescricao(final String descricao) {
        return TipoIdentificacao.lookup.get(descricao);
    }

    static {
        TipoIdentificacao.lookup = gerarLookUp();
    }
}
