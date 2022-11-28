package com.equipeturma862.cadastronf.exceptions;

public class AgenciaNotFound extends RuntimeException  {

    public AgenciaNotFound () {
        super("Identificação da agência é obrigatória.");

    }
}
