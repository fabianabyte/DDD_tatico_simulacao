package com.br.simulacao.service;

import com.br.simulacao.configuration.mapper.MapperConfig;
import com.br.simulacao.domain.model.api.Simulacao;
import com.br.simulacao.repository.SimulacaoRepository;
import com.br.simulacao.utils.pessoa.PessoaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimulacaoService {
    @Autowired
    SimulacaoRepository simulacaoRepository;

    public Simulacao criarSimulacao(Simulacao simulacao){
        return MapperConfig
                .getSimulacaoMapper()
                .simulacaoEntityParaSimulacao(
                        simulacaoRepository.save(
                                MapperConfig
                                        .getSimulacaoMapper()
                                        .simulacaoParaSimulacaoEntity(simulacao)
                        )
                );
    }

    public List<Simulacao> obterTodasSimulacoes() {
        return simulacaoRepository.findAll().stream().map(simulacaoEntity -> MapperConfig.getSimulacaoMapper().simulacaoEntityParaSimulacao(simulacaoEntity)).collect(Collectors.toList());
    }

    public List<Simulacao> obterSimulacoesPorPessoa(String idPessoa) {
        return simulacaoRepository.findBypessoa_identificacao(
                PessoaFactory.gerarPessoaEntity(idPessoa)).stream()
                    .map(simulacaoEntity -> MapperConfig.getSimulacaoMapper().simulacaoEntityParaSimulacao(simulacaoEntity))
                .collect(Collectors.toList());
    }

}
