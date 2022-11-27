package com.equipeturma862.cadastronf.exceptions;

public class ValidationRequired extends RuntimeException{

    public ValidationRequired(){
        super ("Numero de Nota Fiscal e Natureza da Operação obrigatórios");
    }
}
