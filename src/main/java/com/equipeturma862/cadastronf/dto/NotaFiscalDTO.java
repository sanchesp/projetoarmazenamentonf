package com.equipeturma862.cadastronf.dto;

import com.equipeturma862.cadastronf.domain.Remetente;
import com.equipeturma862.cadastronf.domain.TipoNaturezaOperacao;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Setter
public class NotaFiscalDTO {

    private Long id;
    private Long numeroNotaFiscal;
    @NotNull
    private LocalDate dataEmissao;
    @NotNull
    private LocalDate dataPrestacaoServico;
    @NotNull
    private BigDecimal valor;

    private TipoNaturezaOperacao tipoNaturezaOperacao;

    private Remetente remetente;

}
