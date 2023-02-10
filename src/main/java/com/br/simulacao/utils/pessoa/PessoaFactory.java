package com.br.simulacao.utils.pessoa;

import com.br.simulacao.domain.entidade.pessoa.PessoaEntidade;
import com.br.simulacao.domain.model.api.pessoa.TipoPessoa;
import com.br.simulacao.utils.identificacao.IdentificacaoFactory;
import com.br.simulacao.utils.identificacao.domain.model.TipoIdentificacao;

public class PessoaFactory {
    private PessoaFactory(){}

    public static PessoaEntidade gerarPessoaEntidade(String identificacao){
        return PessoaEntidade.builder()
                .tipoPessoa(IdentificacaoFactory.getIdentificacao(identificacao).getTipoIdentificacao().getDescricao())
                .identificacao(identificacao)
                .build();
    }
    public static PessoaEntidade gerarPessoaFisicaEntidade(String identificacao){
        return PessoaEntidade.builder()
                .tipoPessoa(TipoPessoa.CPF.getDescricao())
                .identificacao(identificacao)
                .build();
    }
    public static PessoaEntidade gerarPessoaJuridicaEntidade(String identificacao){
        return PessoaEntidade.builder()
                .tipoPessoa(TipoPessoa.CNPJ.getDescricao())
                .identificacao(identificacao)
                .build();
    }
    public static PessoaEntidade gerarPessoaEntidade(String identificacao, TipoIdentificacao tipoIdentificacao){
        return PessoaEntidade.builder()
                .tipoPessoa(tipoIdentificacao.getDescricao())
                .identificacao(identificacao)
                .build();
    }
}
