package com.equipeturma862.cadastronf.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table
@Setter
@Getter
public class TipoNaturezaOperacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
}
