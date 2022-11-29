package com.equipeturma862.cadastronf.exceptions;

public class FuncionarioExists extends RuntimeException{
    public FuncionarioExists(){
        super("Funcionário já cadastrado");
    }

}
