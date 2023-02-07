package com.br.simulacao.utils.pessoa;

import com.br.simulacao.domain.entity.PessoaEntity;
import com.br.simulacao.domain.model.api.pessoa.TipoPessoa;
import com.br.simulacao.utils.identificacao.IdentificacaoFactory;
import com.br.simulacao.utils.identificacao.domain.model.Identificacao;

public class PessoaFactory {

    public static PessoaEntity gerarPessoaEntity(String identificacao){
        return PessoaEntity.builder()
                .tipoPessoa(IdentificacaoFactory.getIdentificacao(identificacao).getTipoIdentificacao().getDescricao())
                .identificacao(identificacao)
                .build();
    }
}
