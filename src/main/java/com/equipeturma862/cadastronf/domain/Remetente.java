package com.equipeturma862.cadastronf.domain;

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
public class Remetente {

    @Id
    private Long id;
    private String CNPJ;
    private String razaoSocial;
    private String telefone;

    @OneToMany
    private List<NotaFiscal> notaFiscais;

}
