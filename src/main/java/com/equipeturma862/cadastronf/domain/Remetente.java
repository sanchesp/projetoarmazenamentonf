package com.equipeturma862.cadastronf.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Remetente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private ClassificacaoPessoa tipoDePessoa;
    private String CNPJ;
    private String CPF;
    private String razaoSocial;
    private String telefone;

    @OneToMany
    private List<NotaFiscal> notaFiscais;

}
