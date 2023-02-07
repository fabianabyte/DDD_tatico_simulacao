package com.br.simulacao.controller;


import com.br.simulacao.configuration.mapper.MapperConfig;
import com.br.simulacao.domain.entidade.SimulacaoEntity;
import com.br.simulacao.domain.model.api.Simulacao;
import com.br.simulacao.domain.model.api.pessoa.Contato;
import com.br.simulacao.domain.model.api.pessoa.Pessoa;
import com.br.simulacao.domain.model.api.produto.Produto;
import com.br.simulacao.domain.model.api.produto.TipoProduto;
import com.br.simulacao.repository.SimulacaoRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/simulacoes")
public class SimulacaoController {

    @Autowired
    SimulacaoRepository simulacaoRepository;

    @GetMapping("/teste")
    public String obterSimulacao() {
        return new Gson().toJson(
                Simulacao.builder()
                        .pessoa(Pessoa.builder()
                                .nome("Fabiana")
                                .contato(Contato.builder()
                                        .telefone("chama inbox ;)")
                                        .logradouro("Melhor rua possivel")
                                        .email("fabianabyte@gmail.com")
                                        .build())
                                .build())
                        .produto(Produto.builder()
                                .nome("Veículo")
                                .tipoProduto(TipoProduto.VEICULO)
                                .build())
                        .taxaMensal(0.15)
                        .quantidadePrestacoes(60)
                        .taxaAnual(0.20)
                        .valorEntrada(1000D)
                        .valorPrestacao(200.5)
                        .valorTotalContrato(20000D)
                        .build()
        );
    }

    @GetMapping("/")
    public ResponseEntity<List<Simulacao>> getTodasSimulacoes() {
        try {
            List<Simulacao> simulacoes = simulacaoRepository.findAll().stream().map(simulacaoEntity -> MapperConfig.getSimulacaoMapper().simulacaoEntityParaSimulacao(simulacaoEntity)).collect(Collectors.toList());

            if (simulacoes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(simulacoes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<SimulacaoEntity> criarSimulacao(@RequestBody Simulacao simulacao) {
        try {
            SimulacaoEntity simulacaoEntity = simulacaoRepository.save(MapperConfig.getSimulacaoMapper().simulacaoParaSimulacaoEntity(simulacao));
            return new ResponseEntity<>(simulacaoEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
