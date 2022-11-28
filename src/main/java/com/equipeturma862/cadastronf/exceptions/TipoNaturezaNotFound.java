package com.equipeturma862.cadastronf.exceptions;

public class TipoNaturezaNotFound extends RuntimeException{

    public TipoNaturezaNotFound(){
        super("Natureza da operação não localizado");
    }
}
