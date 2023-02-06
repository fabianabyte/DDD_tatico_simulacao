package com.br.simulacao.domain.entidade;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaEntity {

    @Id
    @Column(name = "identificacao")
    @Setter(AccessLevel.NONE)
    private String identificacao;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "contato_id")
    private ContatoEntity contato;

    @Column(name = "tipo_pessoa")
    private String tipoPessoa;

    @Column(name = "nome")
    private String nome;
}
