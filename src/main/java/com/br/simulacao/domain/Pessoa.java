package com.br.simulacao.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Pessoa {
    private String nome;
    private String endereco;
}
