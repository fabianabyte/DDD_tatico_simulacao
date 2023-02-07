package com.br.simulacao.utils.pessoa;

import com.br.simulacao.domain.entity.PessoaEntity;
import com.br.simulacao.utils.identificacao.IdentificacaoFactory;

public class PessoaFactory {
    private PessoaFactory(){}

    public static PessoaEntity gerarPessoaEntity(String identificacao){
        return PessoaEntity.builder()
                .tipoPessoa(IdentificacaoFactory.getIdentificacao(identificacao).getTipoIdentificacao().getDescricao())
                .identificacao(identificacao)
                .build();
    }
}
