package com.equipeturma862.cadastronf.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Setter
@Getter
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate dataEmissao;
    private BigDecimal valor;

    @OneToOne(cascade = CascadeType.PERSIST)
    private TipoNaturezaOperacao tipoNaturezaOperacao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Remetente remetente;

}
