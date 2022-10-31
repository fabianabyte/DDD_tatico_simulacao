package com.br.simulacao.factories;

import com.br.simulacao.domain.mapper.SimulacaoMapper;
import org.mapstruct.factory.Mappers;

public class MapperFactory {

    public static <T> T factory(final Class<T> clazz){
        return Mappers.getMapper(clazz);
    }

    public static SimulacaoMapper getSimulacaoMapper(){
        return factory(SimulacaoMapper.class);
    }
}
