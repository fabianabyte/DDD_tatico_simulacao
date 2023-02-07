package com.br.simulacao.utils.identificacao.domain.model;

public interface Identificacao {
    TipoIdentificacao getTipoIdentificacao();
    String getIdentificacaoFormatada();
    void validar() throws IllegalArgumentException;
    Byte calcularDV();

}
