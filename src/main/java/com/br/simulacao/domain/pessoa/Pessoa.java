package com.br.simulacao.domain.pessoa;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Pessoa {
    private String nome;
    private Contato contato;
}
