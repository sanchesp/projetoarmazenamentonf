package com.equipeturma862.cadastronf.controller;

import com.equipeturma862.cadastronf.domain.TipoNaturezaOperacao;
import com.equipeturma862.cadastronf.dto.TipoNaturezaOperacaoDTO;
import com.equipeturma862.cadastronf.service.TipoNaturezaOperacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("tipos-naturezas-operacoes")
@RequiredArgsConstructor
public class TipoNaturezaOperacaoController {

    private final TipoNaturezaOperacaoService tipoNaturezaOperacaoService;

    @GetMapping
    List<TipoNaturezaOperacaoDTO> list(String nome) {

        List<TipoNaturezaOperacao> list = tipoNaturezaOperacaoService.list(nome);

        return list.stream().map(tipoNaturezaOperacao -> TipoNaturezaOperacaoDTO.builder()
                .id(tipoNaturezaOperacao.getId())
                .nome(tipoNaturezaOperacao.getNome()).build()).toList();
    }
    @GetMapping("{tipoNaturezaOperacaoId}")
    TipoNaturezaOperacao getById(@PathVariable Long tipoNaturezaOperacaoId) {
        return tipoNaturezaOperacaoService.getById(tipoNaturezaOperacaoId);
    }
    @PostMapping
    TipoNaturezaOperacao save(@RequestBody @Valid TipoNaturezaOperacaoDTO tipoNaturezaOperacaoDTO) {
        TipoNaturezaOperacao tipoNaturezaOperacaoBuilder = TipoNaturezaOperacao.builder()
                .id(tipoNaturezaOperacaoDTO.getId())
                .nome(tipoNaturezaOperacaoDTO.getNome())
                .build();
        return tipoNaturezaOperacaoService.save(tipoNaturezaOperacaoBuilder);
    }

    @PutMapping("{tipoNaturezaOperacaoId}")
    TipoNaturezaOperacao update(@PathVariable Long tipoNaturezaOperacaoId, @RequestBody TipoNaturezaOperacaoDTO tipoNaturezaOperacaoDTO) {
        TipoNaturezaOperacao tipoNaturezaOperacaoBuilder = TipoNaturezaOperacao.builder()
                .id(tipoNaturezaOperacaoDTO.getId())
                .nome(tipoNaturezaOperacaoDTO.getNome())
                .build();
        return tipoNaturezaOperacaoService.update(tipoNaturezaOperacaoId, tipoNaturezaOperacaoBuilder);
    }

    @DeleteMapping("{tipoNaturezaOperacaoId}")
    void delete(@PathVariable Long tipoNaturezaOperacaoId) {
        tipoNaturezaOperacaoService.delete(tipoNaturezaOperacaoId);
    }
}
