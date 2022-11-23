package com.equipeturma862.cadastronf.builder;

import com.equipeturma862.cadastronf.domain.NotaFiscal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class NotaFiscalBuilder {

    private static NotaFiscal notaFiscal;

    public static NotaFiscalBuilder retornaNotaFiscalBuilder () {
        NotaFiscalBuilder notaFiscalBuilder = new NotaFiscalBuilder();
        notaFiscalBuilder.notaFiscal = new NotaFiscal();
        return notaFiscalBuilder;
    }


    public NotaFiscal get(){
        return notaFiscal;
    }

}
