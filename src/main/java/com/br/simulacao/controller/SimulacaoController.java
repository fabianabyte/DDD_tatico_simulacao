package com.br.simulacao.controller;

import com.br.simulacao.domain.Simulacao;
import com.br.simulacao.domain.pessoa.Contato;
import com.br.simulacao.domain.pessoa.Pessoa;
import com.br.simulacao.domain.produto.Produto;
import com.br.simulacao.domain.produto.TipoProduto;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/simulacao")
public class SimulacaoController {

    @GetMapping("/")
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
}
