package com.br.simulacao.controller;


import com.br.simulacao.domain.api.Simulacao;
import com.br.simulacao.domain.entity.SimulacaoEntity;
import com.br.simulacao.domain.api.pessoa.Contato;
import com.br.simulacao.domain.api.pessoa.Pessoa;
import com.br.simulacao.domain.api.produto.Produto;
import com.br.simulacao.domain.api.produto.TipoProduto;
import com.br.simulacao.repository.SimulacaoRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
                                        .celular("chama inbox ;)")
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
    public ResponseEntity<List<Simulacao>> getTodasSimulacoes(@RequestParam(required = false) String title) {
        try {
            List<Simulacao> simulacoes = new ArrayList<>();

            simulacaoRepository.findAll().stream().map(simulacaoEntity -> {
                return Simulacao.builder()
                        .taxaAnual(simulacaoEntity.getTaxaAnual())
                        .taxaMensal(simulacaoEntity.getTaxaMensal())
                        .quantidadePrestacoes(simulacaoEntity.getQuantidadePrestacoes())
                        .valorPrestacao(simulacaoEntity.getValorPrestacao())
                        .valorEntrada(simulacaoEntity.getValorEntrada())
                        .valorTotalContrato(simulacaoEntity.getValorTotalContrato())
                        .build();
            }).collect(Collectors.toList());

            if (simulacoes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(simulacoes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<SimulacaoEntity> criarSimulacao(@RequestBody Simulacao simulacao) {
        try {
            SimulacaoEntity _simulacao = simulacaoRepository.save(SimulacaoEntity.builder()
                            .taxaMensal(simulacao.getTaxaMensal())
                            .quantidadePrestacoes(simulacao.getQuantidadePrestacoes())
                            .taxaAnual(simulacao.getTaxaAnual())
                            .valorEntrada(simulacao.getValorEntrada())
                            .valorPrestacao(simulacao.getValorPrestacao())
                            .valorTotalContrato(simulacao.getValorTotalContrato())
                    .build());
            return new ResponseEntity<>(_simulacao, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
