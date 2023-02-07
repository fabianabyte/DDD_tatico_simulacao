package com.br.simulacao.repository;

import com.br.simulacao.domain.entity.SimulacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SimulacaoRepository extends JpaRepository<SimulacaoEntity, UUID> {

    List<SimulacaoEntity> findByPessoaIdentificacao(String idPessoa);
}
