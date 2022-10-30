package com.equipeturma862.cadastronf.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Setter
@Getter

public class Funcionario {

    @Id
    private Integer id;
    private String nome;
    private Integer idAgencia;
    private Integer funcional;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Agencia that = (Agencia) o;
        return id.equals(that.id);
    }

}