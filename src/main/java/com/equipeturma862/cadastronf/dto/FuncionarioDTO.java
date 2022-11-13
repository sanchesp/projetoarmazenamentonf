package com.equipeturma862.cadastronf.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FuncionarioDTO {

    private Long id;
    private String nome;
    private Long funcional;
    private String email;
}
