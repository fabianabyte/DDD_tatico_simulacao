package com.br.simulacao.domain.mapper;

import com.br.simulacao.domain.model.api.Simulacao;
import com.br.simulacao.domain.entidade.SimulacaoEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SimulacaoMapper {

    Simulacao simulacaoEntityParaSimulacao(SimulacaoEntity simulacaoEntity);
    SimulacaoEntity simulacaoParaSimulacaoEntity(Simulacao simulacao);

}
