package com.equipeturma862.cadastronf.dto;

import com.equipeturma862.cadastronf.domain.ClassificacaoPessoa;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RemetenteDTO {

    private Long id;
    private ClassificacaoPessoa tipoDePessoa;
    private String CNPJ;
    private String CPF;
    private String razaoSocial;
    private String telefone;
}
