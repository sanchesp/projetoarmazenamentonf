package com.equipeturma862.cadastronf.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
public class AgenciaDTO {

    private Long id;

    @NotNull
    private Long numeroDeIdentificacao;

    @NotBlank
    private String nome;

    @Email
    private String email;
}
