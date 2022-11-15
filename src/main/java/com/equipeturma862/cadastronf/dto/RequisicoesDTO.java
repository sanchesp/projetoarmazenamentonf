package com.equipeturma862.cadastronf.dto;

import com.equipeturma862.cadastronf.domain.Funcionario;
import com.equipeturma862.cadastronf.domain.NotaFiscal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class RequisicoesDTO {

    private Long id;
    private LocalDateTime dataHoraRegistro;
    private String detalheDoTrajeto;
    private Funcionario funcionarioSolicitante;
    private NotaFiscal notaFiscal;
}
