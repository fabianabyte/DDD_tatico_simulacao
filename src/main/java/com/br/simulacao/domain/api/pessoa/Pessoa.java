package com.br.simulacao.domain.api.pessoa;

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
