package com.br.simulacao.configuration.mapper;

import com.br.simulacao.domain.mapper.SimulacaoMapper;
import org.mapstruct.factory.Mappers;

public class MapperConfig {

    public static <T> T factory(final Class<T> clazz){
        return Mappers.getMapper(clazz);
    }

    public static SimulacaoMapper getSimulacaoMapper(){
        return factory(SimulacaoMapper.class);
    }
}