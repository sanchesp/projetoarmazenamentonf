package com.equipeturma862.cadastronf.controller;

import com.equipeturma862.cadastronf.domain.NotaFiscal;
import com.equipeturma862.cadastronf.dto.NotaFiscalDTO;
import com.equipeturma862.cadastronf.service.NotaFiscalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("remetente/{remetenteId}/notas-fiscais")
@RequiredArgsConstructor
public class NotaFiscalController {

    private final NotaFiscalService notaFiscalService;

    @PostMapping
    NotaFiscal save(@RequestBody @Valid NotaFiscalDTO notaFiscalDTO, Long remetenteId) {
        NotaFiscal notafiscalBuilder = NotaFiscal.builder()
                .numeroNotaFiscal(notaFiscalDTO.getNumeroNotaFiscal())
                .dataEmissao(notaFiscalDTO.getDataEmissao())
                .dataPrestacaoServico(notaFiscalDTO.getDataPrestacaoServico())
                .valor(notaFiscalDTO.getValor())
                .tipoNaturezaOperacao(notaFiscalDTO.getTipoNaturezaOperacao())
                .remetente(notaFiscalDTO.getRemetente()).build();
        return notaFiscalService.save( notafiscalBuilder, remetenteId);
    }

    @GetMapping
    List<NotaFiscalDTO> list(String nome) {

        List<NotaFiscal> list = notaFiscalService.list(nome);

        return list.stream().map(notaFiscal -> NotaFiscalDTO.builder()
                .numeroNotaFiscal(notaFiscal.getNumeroNotaFiscal())
                .dataEmissao(notaFiscal.getDataEmissao())
                .dataPrestacaoServico(notaFiscal.getDataPrestacaoServico())
                .valor(notaFiscal.getValor())
                .tipoNaturezaOperacao(notaFiscal.getTipoNaturezaOperacao())
                .remetente(notaFiscal.getRemetente()).build()).toList();
    }
    @GetMapping("{notasFiscaisId}")
    NotaFiscal getById(@PathVariable Long notasFiscaisId) {
        return notaFiscalService.getById(notasFiscaisId);
    }
    @PutMapping("{notasFiscaisId}")
    NotaFiscal update(@PathVariable Long notasFiscaisId, @RequestBody NotaFiscalDTO notaFiscalDTO) {
        NotaFiscal notaFiscalBuilder = NotaFiscal.builder()
                .numeroNotaFiscal(notaFiscalDTO.getNumeroNotaFiscal())
                .dataEmissao(notaFiscalDTO.getDataEmissao())
                .dataPrestacaoServico(notaFiscalDTO.getDataPrestacaoServico())
                .valor(notaFiscalDTO.getValor())
                .tipoNaturezaOperacao(notaFiscalDTO.getTipoNaturezaOperacao())
                .remetente(notaFiscalDTO.getRemetente()).build();
        return notaFiscalService.update(notasFiscaisId, notaFiscalBuilder);
    }

    @DeleteMapping("{notasFiscaisId}")
    void delete(@PathVariable Long notasFiscaisId) {
        notaFiscalService.delete(notasFiscaisId);
    }
}
