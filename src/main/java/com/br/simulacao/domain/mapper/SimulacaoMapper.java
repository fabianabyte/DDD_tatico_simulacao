package com.br.simulacao.domain.mapper;

import com.br.simulacao.domain.model.api.Simulacao;
import com.br.simulacao.domain.entity.SimulacaoEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SimulacaoMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Simulacao simulacaoEntityParaSimulacao(SimulacaoEntity simulacaoEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SimulacaoEntity simulacaoParaSimulacaoEntity(Simulacao simulacao);

}
