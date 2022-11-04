package com.equipeturma862.cadastronf.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AgenciaDTO {

    private Integer id;
    private Integer numeroDeIdentificacao;
    private String nome;
    private String email;
}
