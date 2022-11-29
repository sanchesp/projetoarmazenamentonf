package com.equipeturma862.cadastronf.exceptions;

public class AgenciaNotFound extends RuntimeException  {

    public AgenciaNotFound () {
        super("A agência não existe");

    }
}
