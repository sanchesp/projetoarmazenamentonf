package com.equipeturma862.cadastronf.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    private Integer numeroDeIdentificacao;
    private String email;

    @OneToMany
    private List<Funcionario> funcionarios;
}
