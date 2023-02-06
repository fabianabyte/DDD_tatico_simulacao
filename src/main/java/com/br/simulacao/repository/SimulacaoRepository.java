package com.br.simulacao.repository;

import com.br.simulacao.domain.entidade.SimulacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SimulacaoRepository extends JpaRepository<SimulacaoEntity, UUID> {
}
