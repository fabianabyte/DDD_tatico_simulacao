package com.br.simulacao.domain.mapper;

import com.br.simulacao.domain.entity.PessoaEntity;
import com.br.simulacao.domain.model.api.pessoa.Pessoa;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PessoaMapper {

    PessoaEntity converterPessoaEmPessoaEntity(Pessoa pessoa);

    Pessoa converterPessoaEntityEmPessoa(PessoaEntity pessoaEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PessoaEntity atualizacaoParcial(Pessoa pessoa, @MappingTarget PessoaEntity pessoaEntity);
}