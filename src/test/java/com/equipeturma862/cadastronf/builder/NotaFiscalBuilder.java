package com.equipeturma862.cadastronf.builder;

import com.equipeturma862.cadastronf.domain.FileNotaFiscal;
import com.equipeturma862.cadastronf.domain.NotaFiscal;
import com.equipeturma862.cadastronf.domain.Remetente;
import com.equipeturma862.cadastronf.domain.TipoNaturezaOperacao;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
public class NotaFiscalBuilder {

    private static NotaFiscal notaFiscal;

    public static NotaFiscalBuilder retornaNotaFiscalBuilder () {
        NotaFiscalBuilder notaFiscalBuilder = new NotaFiscalBuilder();
       notaFiscalBuilder.notaFiscal = new NotaFiscal(1L, 1234l, LocalDate.of(2022,11,01),
               LocalDate.of(2022,10,31), BigDecimal.TEN,
                TipoNaturezaOperacao.builder().build(), Remetente.builder().build(), FileNotaFiscal.builder().build());
        return notaFiscalBuilder;
    }


    public NotaFiscal get(){
        return notaFiscal;
    }

}
