package com.equipeturma862.cadastronf.builder;

import com.equipeturma862.cadastronf.domain.NotaFiscal;
import com.equipeturma862.cadastronf.domain.Remetente;
import com.equipeturma862.cadastronf.domain.TipoNaturezaOperacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NotaFiscalProvider {

    public static NotaFiscal get(){
        return new NotaFiscal(1L, 1234l, LocalDate.of(2022,11,01),
                LocalDate.of(2022,10,31), BigDecimal.TEN,
                TipoNaturezaOperacao.builder().build(), Remetente.builder().build());
    }
}
