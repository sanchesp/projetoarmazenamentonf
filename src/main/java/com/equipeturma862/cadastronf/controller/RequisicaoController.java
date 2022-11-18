package com.equipeturma862.cadastronf.controller;

import com.equipeturma862.cadastronf.domain.Requisicao;
import com.equipeturma862.cadastronf.dto.RequisicoesDTO;
import com.equipeturma862.cadastronf.service.RequisicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping ("requisicoes")
@RequiredArgsConstructor
public class RequisicaoController {

    private final RequisicaoService requisicaoService;

    @GetMapping
    List<RequisicoesDTO> list(String nome) {

        List<Requisicao> list = requisicaoService.list(nome);

        return list.stream().map(requisicao -> RequisicoesDTO.builder()
                .id(requisicao.getId())
                .dataHoraRegistro(requisicao.getDataHoraRegistro())
                .detalheDoTrajeto(requisicao.getDetalheDoTrajeto())
                .funcionarioSolicitante(requisicao.getFuncionarioSolicitante())
                .notaFiscal(requisicao.getNotaFiscal()).build()).toList();
    }
    @GetMapping("{requisicoesId}")
    Requisicao getById(@PathVariable Long requisicoesId) {
        return requisicaoService.getById(requisicoesId);
    }
    @PostMapping
    Requisicao save(@RequestBody @Valid RequisicoesDTO requisicoesDTO) {
        Requisicao requisicaoBuilder = Requisicao.builder()
                .id(requisicoesDTO.getId())
                .dataHoraRegistro(LocalDateTime.now())
                .detalheDoTrajeto(requisicoesDTO.getDetalheDoTrajeto())
                .funcionarioSolicitante(requisicoesDTO.getFuncionarioSolicitante())
                .notaFiscal(requisicoesDTO.getNotaFiscal())
                .build();
        return requisicaoService.save(requisicaoBuilder);
    }

    @PutMapping("{requisicoesId}")
    Requisicao update(@PathVariable Long requisicoesId, @RequestBody RequisicoesDTO requisicoesDTO) {
        Requisicao requisicaoBuilder = Requisicao.builder()
                .id(requisicoesDTO.getId())
                .dataHoraRegistro(requisicoesDTO.getDataHoraRegistro())
                .detalheDoTrajeto(requisicoesDTO.getDetalheDoTrajeto())
                .funcionarioSolicitante(requisicoesDTO.getFuncionarioSolicitante())
                .notaFiscal(requisicoesDTO.getNotaFiscal())
                .build();
        return requisicaoService.update(requisicoesId, requisicaoBuilder);
    }

    @DeleteMapping("{requisicoesId}")
    void delete(@PathVariable Long requisicoesId) {
        requisicaoService.delete(requisicoesId);
    }

}

