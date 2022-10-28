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
    private Long id;
    private LocalDate dataEmissao;
    private BigDecimal valor;

    @OneToOne
    @JoinColumn(name = "tipo_natureza_operacao_id")
    private TipoNaturezaOperacao tipoNaturezaOperacao;

    @OneToOne
    @JoinColumn(name = "remetente_id")
    private Remetente remetente;

}
