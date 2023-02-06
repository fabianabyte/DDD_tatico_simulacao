package com.br.simulacao.domain.mapper;

import com.br.simulacao.domain.entidade.PessoaEntity;
import com.br.simulacao.domain.model.api.pessoa.Pessoa;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PessoaMapper {

    PessoaEntity toPessoaFisicaEntity(Pessoa pessoa);

    Pessoa toPessoaFisicaDto(PessoaEntity pessoaEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PessoaEntity partialUpdate(Pessoa pessoa, @MappingTarget PessoaEntity pessoaEntity);
}