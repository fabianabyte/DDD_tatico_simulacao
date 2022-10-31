package com.br.simulacao.domain.mapper;

import com.br.simulacao.domain.api.Simulacao;
import com.br.simulacao.domain.entity.SimulacaoEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SimulacaoMapper {

    Simulacao simulacaoEntityParaSimulacao(SimulacaoEntity simulacaoEntity);
    SimulacaoEntity simulacaoParaSimulacaoEntity(Simulacao simulacao);

}
