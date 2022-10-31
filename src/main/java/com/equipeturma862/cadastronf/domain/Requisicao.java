package com.equipeturma862.cadastronf.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
@Setter
@Getter
public class Requisicao {

    @Id
    private Integer id;
    private LocalDateTime dataHoraRegistro;

    @OneToOne
    private Funcionario funcionarioSolicitante;

    @OneToOne
    private NotaFiscal notaFiscal;

}
