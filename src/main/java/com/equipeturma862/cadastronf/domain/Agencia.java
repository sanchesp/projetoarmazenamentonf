package com.equipeturma862.cadastronf.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Agencia {

    @Id
    private Integer id;
    private String nome;
    private Integer numeroDeIdentificacao;
    private String email;

    @OneToMany
    @JsonIgnoreProperties("agencia")
    private List<Funcionario> funcionarios;
}
