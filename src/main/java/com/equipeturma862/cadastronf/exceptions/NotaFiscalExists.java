package com.equipeturma862.cadastronf.exceptions;

public class NotaFiscalExists extends RuntimeException{

    public NotaFiscalExists () {
        super("Nota Fiscal já existente");

    }
}
