package com.br.simulacao.domain.api.pessoa;

import com.br.simulacao.domain.identificacao.Identificacao;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Pessoa {
    private String nome;
    private Contato contato;
    private String identificacao;
}
