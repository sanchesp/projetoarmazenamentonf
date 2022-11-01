package com.equipeturma862.cadastronf.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Remetente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String CNPJ;
    private String razaoSocial;
    private String telefone;

    @OneToMany
    private List<NotaFiscal> notaFiscais;

}
