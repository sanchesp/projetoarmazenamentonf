package com.equipeturma862.cadastronf.exceptions;

public class FuncionarioSolicitante extends RuntimeException{

    public FuncionarioSolicitante(){
        super("Obrigatório dados do solicitante");
    }
}
