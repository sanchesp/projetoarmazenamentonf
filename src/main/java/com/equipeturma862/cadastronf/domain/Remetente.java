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
public class Remetente {

    @Id
    private Long id;
    private String CNPJ;
    private String razaoSocial;
    private String telefone;

}
