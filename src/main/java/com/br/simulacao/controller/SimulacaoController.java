package com.br.simulacao.controller;

import com.br.simulacao.domain.Pessoa;
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
        return new Gson().toJson(Pessoa.builder().nome("Fabiana Alencar").endereco("País das maravilhas."));
    }
}
