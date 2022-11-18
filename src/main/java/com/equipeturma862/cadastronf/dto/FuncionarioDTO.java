package com.equipeturma862.cadastronf.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
public class FuncionarioDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private Long funcional;

    @Email
    private String email;
}
