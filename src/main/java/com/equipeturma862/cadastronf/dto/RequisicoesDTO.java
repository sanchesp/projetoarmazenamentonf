package com.equipeturma862.cadastronf.dto;

import com.equipeturma862.cadastronf.domain.Funcionario;
import com.equipeturma862.cadastronf.domain.NotaFiscal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class RequisicoesDTO {

    private Long id;
    private LocalDateTime dataHoraRegistro;
    @NotNull
    private String detalheDoTrajeto;
    @NotNull
    private Long numeroDaAgenciaSolicitante;
    private Funcionario funcionarioSolicitante;
    private NotaFiscal notaFiscal;
}
