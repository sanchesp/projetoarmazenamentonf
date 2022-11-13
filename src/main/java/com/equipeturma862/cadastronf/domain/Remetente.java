package com.equipeturma862.cadastronf.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Remetente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private ClassificacaoPessoa tipoDePessoa;
    private String CNPJ;
    private String razaoSocial;
    private String telefone;

    @OneToMany
    private List<NotaFiscal> notaFiscais;

}
