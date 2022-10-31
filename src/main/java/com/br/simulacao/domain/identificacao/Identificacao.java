package com.br.simulacao.domain.identificacao;

public interface Identificacao {
    TipoIdentificacao getTipoIdentificacao();
    String getIdentificacaoFormatada();
    void validar() throws Exception;
    Byte calcularDV();

}
