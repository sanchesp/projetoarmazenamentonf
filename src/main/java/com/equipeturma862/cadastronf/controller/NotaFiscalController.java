package com.equipeturma862.cadastronf.controller;

import com.equipeturma862.cadastronf.domain.NotaFiscal;
import com.equipeturma862.cadastronf.dto.NotaFiscalDTO;
import com.equipeturma862.cadastronf.service.NotaFiscalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("remetentes/{remetenteId}/notas-fiscais")
@RequiredArgsConstructor
public class NotaFiscalController {

    private final NotaFiscalService notaFiscalService;

    @PostMapping
    NotaFiscal save(@RequestBody @Valid NotaFiscalDTO notaFiscalDTO, @PathVariable Long remetenteId) {
        NotaFiscal notafiscalBuilder = NotaFiscal.builder()
                .numeroNotaFiscal(notaFiscalDTO.getNumeroNotaFiscal())
                .dataEmissao(notaFiscalDTO.getDataEmissao())
                .dataPrestacaoServico(notaFiscalDTO.getDataPrestacaoServico())
                .valor(notaFiscalDTO.getValor())
                .tipoNaturezaOperacao(notaFiscalDTO.getTipoNaturezaOperacao())
                .remetente(notaFiscalDTO.getRemetente()).build();
        return notaFiscalService.save(notafiscalBuilder, remetenteId);
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
    @GetMapping("{notaFiscaiId}")
    NotaFiscal getById(@PathVariable Long notaFiscalId) {
        return notaFiscalService.getById(notaFiscalId);
    }
    @PutMapping("{notaFiscalId}")
    NotaFiscal update(@PathVariable Long notaFiscalId, @RequestBody NotaFiscalDTO notaFiscalDTO) {
        NotaFiscal notaFiscalBuilder = NotaFiscal.builder()
                .numeroNotaFiscal(notaFiscalDTO.getNumeroNotaFiscal())
                .dataEmissao(notaFiscalDTO.getDataEmissao())
                .dataPrestacaoServico(notaFiscalDTO.getDataPrestacaoServico())
                .valor(notaFiscalDTO.getValor())
                .tipoNaturezaOperacao(notaFiscalDTO.getTipoNaturezaOperacao())
                .remetente(notaFiscalDTO.getRemetente()).build();
        return notaFiscalService.update(notaFiscalId, notaFiscalBuilder);
    }

    @DeleteMapping("{notaFiscalId}")
    void delete(@PathVariable Long notaFiscalId) {
        notaFiscalService.delete(notaFiscalId);
    }
}
