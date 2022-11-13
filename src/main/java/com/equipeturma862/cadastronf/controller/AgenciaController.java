package com.equipeturma862.cadastronf.controller;

import com.equipeturma862.cadastronf.domain.Agencia;
import com.equipeturma862.cadastronf.dto.AgenciaDTO;
import com.equipeturma862.cadastronf.service.AgenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("agencias")
@RequiredArgsConstructor
public class AgenciaController {

    private final AgenciaService agenciaService;

    @GetMapping
    List<AgenciaDTO> list(String name) {

        List<Agencia> list = agenciaService.list(name);

        return list.stream().map(agencia -> AgenciaDTO.builder()
                .nome(agencia.getNome())
                .id(agencia.getId())
                .numeroDeIdentificacao(agencia.getNumeroDeIdentificacao())
                .email(agencia.getEmail()).build()).toList();
    }
    @PostMapping
    Agencia save(@RequestBody @Valid AgenciaDTO agenciaDTO) {
        Agencia agencias = Agencia.builder()
                .nome(agenciaDTO.getNome())
                .id(agenciaDTO.getId())
                .numeroDeIdentificacao(agenciaDTO.getNumeroDeIdentificacao())
                .email(agenciaDTO.getEmail())
                .build();
        return agenciaService.save(agencias);
    }

    @PutMapping("{agenciasId}")
    Agencia update(@PathVariable Long agenciasId, @RequestBody AgenciaDTO agenciaDTO) {
        Agencia agenciasBuilder = Agencia.builder()
                .nome(agenciaDTO.getNome())
                .id(agenciaDTO.getId())
                .numeroDeIdentificacao(agenciaDTO.getNumeroDeIdentificacao())
                .email(agenciaDTO.getEmail())
                .build();
        return agenciaService.update(agenciasId, agenciasBuilder);
    }

    @DeleteMapping("{agenciasId}")
    void delete(@PathVariable Long agenciasId) {
        agenciaService.delete(agenciasId);
    }
}

