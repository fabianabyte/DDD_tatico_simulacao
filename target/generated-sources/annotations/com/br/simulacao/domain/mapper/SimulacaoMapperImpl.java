package com.br.simulacao.domain.mapper;

import com.br.simulacao.domain.entidade.SimulacaoEntity;
import com.br.simulacao.domain.entidade.SimulacaoEntity.SimulacaoEntityBuilder;
import com.br.simulacao.domain.model.api.Simulacao;
import com.br.simulacao.domain.model.api.Simulacao.SimulacaoBuilder;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-06T16:09:27-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
public class SimulacaoMapperImpl implements SimulacaoMapper {

    @Override
    public Simulacao simulacaoEntityParaSimulacao(SimulacaoEntity simulacaoEntity) {
        if ( simulacaoEntity == null ) {
            return null;
        }

        SimulacaoBuilder simulacao = Simulacao.builder();

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

        simulacaoEntity.valorEntrada( simulacao.getValorEntrada() );
        simulacaoEntity.valorPrestacao( simulacao.getValorPrestacao() );
        simulacaoEntity.quantidadePrestacoes( simulacao.getQuantidadePrestacoes() );
        simulacaoEntity.valorTotalContrato( simulacao.getValorTotalContrato() );
        simulacaoEntity.taxaMensal( simulacao.getTaxaMensal() );
        simulacaoEntity.taxaAnual( simulacao.getTaxaAnual() );

        return simulacaoEntity.build();
    }
}
