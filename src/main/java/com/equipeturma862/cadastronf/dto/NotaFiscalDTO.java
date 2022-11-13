package com.equipeturma862.cadastronf.dto;

import com.equipeturma862.cadastronf.domain.Remetente;
import com.equipeturma862.cadastronf.domain.TipoNaturezaOperacao;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class NotaFiscalDTO {

    private Long id;
    private Long numeroNotaFiscal;
    private LocalDate dataEmissao;
    private LocalDateTime dataPrestacaoServico;
    private BigDecimal valor;
    private TipoNaturezaOperacao tipoNaturezaOperacao;
    private Remetente remetente;

}
