package com.br.simulacao.utils.pessoa;

import com.br.simulacao.domain.entity.PessoaEntity;
import com.br.simulacao.domain.model.api.pessoa.TipoPessoa;
import com.br.simulacao.utils.identificacao.IdentificacaoFactory;
import com.br.simulacao.utils.identificacao.domain.model.TipoIdentificacao;

public class PessoaFactory {
    private PessoaFactory(){}

    public static PessoaEntity gerarPessoaEntity(String identificacao){
        return PessoaEntity.builder()
                .tipoPessoa(IdentificacaoFactory.getIdentificacao(identificacao).getTipoIdentificacao().getDescricao())
                .identificacao(identificacao)
                .build();
    }
    public static PessoaEntity gerarPessoaFisicaEntity(String identificacao){
        return PessoaEntity.builder()
                .tipoPessoa(TipoPessoa.CPF.getDescricao())
                .identificacao(identificacao)
                .build();
    }
    public static PessoaEntity gerarPessoaJuridicaEntity(String identificacao){
        return PessoaEntity.builder()
                .tipoPessoa(TipoPessoa.CNPJ.getDescricao())
                .identificacao(identificacao)
                .build();
    }
    public static PessoaEntity gerarPessoaEntity(String identificacao, TipoIdentificacao tipoIdentificacao){
        return PessoaEntity.builder()
                .tipoPessoa(tipoIdentificacao.getDescricao())
                .identificacao(identificacao)
                .build();
    }
}
