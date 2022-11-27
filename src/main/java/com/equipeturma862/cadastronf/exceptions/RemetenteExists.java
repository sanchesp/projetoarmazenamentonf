package com.equipeturma862.cadastronf.exceptions;

public class RemetenteExists extends RuntimeException {

    public RemetenteExists (){
        super("Remetente já existente");
    }
}
