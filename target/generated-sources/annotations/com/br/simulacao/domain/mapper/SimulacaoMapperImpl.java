package com.br.simulacao.domain.mapper;

import com.br.simulacao.domain.entidade.ContatoEntity;
import com.br.simulacao.domain.entidade.ContatoEntity.ContatoEntityBuilder;
import com.br.simulacao.domain.entidade.PessoaEntity;
import com.br.simulacao.domain.entidade.PessoaEntity.PessoaEntityBuilder;
import com.br.simulacao.domain.entidade.ProdutoEntity;
import com.br.simulacao.domain.entidade.ProdutoEntity.ProdutoEntityBuilder;
import com.br.simulacao.domain.entidade.SimulacaoEntity;
import com.br.simulacao.domain.entidade.SimulacaoEntity.SimulacaoEntityBuilder;
import com.br.simulacao.domain.model.api.Simulacao;
import com.br.simulacao.domain.model.api.Simulacao.SimulacaoBuilder;
import com.br.simulacao.domain.model.api.pessoa.Contato;
import com.br.simulacao.domain.model.api.pessoa.Contato.ContatoBuilder;
import com.br.simulacao.domain.model.api.pessoa.Pessoa;
import com.br.simulacao.domain.model.api.pessoa.Pessoa.PessoaBuilder;
import com.br.simulacao.domain.model.api.pessoa.TipoPessoa;
import com.br.simulacao.domain.model.api.produto.Produto;
import com.br.simulacao.domain.model.api.produto.Produto.ProdutoBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-06T23:20:40-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class SimulacaoMapperImpl implements SimulacaoMapper {

    @Override
    public Simulacao simulacaoEntityParaSimulacao(SimulacaoEntity simulacaoEntity) {
        if ( simulacaoEntity == null ) {
            return null;
        }

        SimulacaoBuilder simulacao = Simulacao.builder();

        simulacao.pessoa( pessoaEntityToPessoa( simulacaoEntity.getPessoa() ) );
        simulacao.produto( produtoEntityToProduto( simulacaoEntity.getProduto() ) );
        simulacao.valorEntrada( simulacaoEntity.getValorEntrada() );
        simulacao.valorPrestacao( simulacaoEntity.getValorPrestacao() );
        simulacao.quantidadePrestacoes( simulacaoEntity.getQuantidadePrestacoes() );
        simulacao.valorTotalContrato( simulacaoEntity.getValorTotalContrato() );
        simulacao.taxaMensal( simulacaoEntity.getTaxaMensal() );
        simulacao.taxaAnual( simulacaoEntity.getTaxaAnual() );

        return simulacao.build();
    }

    @Override
    public SimulacaoEntity simulacaoParaSimulacaoEntity(Simulacao simulacao) {
        if ( simulacao == null ) {
            return null;
        }

        SimulacaoEntityBuilder simulacaoEntity = SimulacaoEntity.builder();

        simulacaoEntity.pessoa( pessoaToPessoaEntity( simulacao.getPessoa() ) );
        simulacaoEntity.produto( produtoToProdutoEntity( simulacao.getProduto() ) );
        simulacaoEntity.valorEntrada( simulacao.getValorEntrada() );
        simulacaoEntity.valorPrestacao( simulacao.getValorPrestacao() );
        simulacaoEntity.quantidadePrestacoes( simulacao.getQuantidadePrestacoes() );
        simulacaoEntity.valorTotalContrato( simulacao.getValorTotalContrato() );
        simulacaoEntity.taxaMensal( simulacao.getTaxaMensal() );
        simulacaoEntity.taxaAnual( simulacao.getTaxaAnual() );

        return simulacaoEntity.build();
    }

    protected Contato contatoEntityToContato(ContatoEntity contatoEntity) {
        if ( contatoEntity == null ) {
            return null;
        }

        ContatoBuilder contato = Contato.builder();

        contato.logradouro( contatoEntity.getLogradouro() );
        contato.email( contatoEntity.getEmail() );
        contato.telefone( contatoEntity.getTelefone() );

        return contato.build();
    }

    protected Pessoa pessoaEntityToPessoa(PessoaEntity pessoaEntity) {
        if ( pessoaEntity == null ) {
            return null;
        }

        PessoaBuilder pessoa = Pessoa.builder();

        pessoa.nome( pessoaEntity.getNome() );
        pessoa.contato( contatoEntityToContato( pessoaEntity.getContato() ) );
        pessoa.identificacao( pessoaEntity.getIdentificacao() );
        if ( pessoaEntity.getTipoPessoa() != null ) {
            pessoa.tipoPessoa( Enum.valueOf( TipoPessoa.class, pessoaEntity.getTipoPessoa() ) );
        }

        return pessoa.build();
    }

    protected Produto produtoEntityToProduto(ProdutoEntity produtoEntity) {
        if ( produtoEntity == null ) {
            return null;
        }

        ProdutoBuilder produto = Produto.builder();

        return produto.build();
    }

    protected ContatoEntity contatoToContatoEntity(Contato contato) {
        if ( contato == null ) {
            return null;
        }

        ContatoEntityBuilder contatoEntity = ContatoEntity.builder();

        contatoEntity.telefone( contato.getTelefone() );
        contatoEntity.email( contato.getEmail() );
        contatoEntity.logradouro( contato.getLogradouro() );

        return contatoEntity.build();
    }

    protected PessoaEntity pessoaToPessoaEntity(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaEntityBuilder pessoaEntity = PessoaEntity.builder();

        pessoaEntity.identificacao( pessoa.getIdentificacao() );
        pessoaEntity.contato( contatoToContatoEntity( pessoa.getContato() ) );
        if ( pessoa.getTipoPessoa() != null ) {
            pessoaEntity.tipoPessoa( pessoa.getTipoPessoa().name() );
        }
        pessoaEntity.nome( pessoa.getNome() );

        return pessoaEntity.build();
    }

    protected ProdutoEntity produtoToProdutoEntity(Produto produto) {
        if ( produto == null ) {
            return null;
        }

        ProdutoEntityBuilder produtoEntity = ProdutoEntity.builder();

        return produtoEntity.build();
    }
}
