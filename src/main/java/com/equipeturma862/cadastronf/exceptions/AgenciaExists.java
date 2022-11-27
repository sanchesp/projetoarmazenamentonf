package com.equipeturma862.cadastronf.exceptions;

public class AgenciaExists extends RuntimeException{

    public AgenciaExists () {
        super("Agência já existe");

    }
}
