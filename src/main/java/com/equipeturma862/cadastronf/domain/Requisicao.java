package com.equipeturma862.cadastronf.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Setter
@Getter
public class Requisicao {

    @Id
    private Integer id;
    private LocalDateTime dataHoraRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionarioSolicitante;

    @OneToOne
    private NotaFiscal notaFiscal;

}
