package com.equipeturma862.cadastronf.controller;

import com.equipeturma862.cadastronf.domain.Agencia;
import com.equipeturma862.cadastronf.dto.AgenciaDTO;
import com.equipeturma862.cadastronf.service.AgenciaService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("agencias")
public class AgenciaController {

    private final AgenciaService agenciaService;


    public AgenciaController(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }
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
    Agencia save(@RequestBody @Valid AgenciaDTO agencia) {
        Agencia agencias = Agencia.builder()
                .nome(agencia.getNome())
                .id(agencia.getId())
                .numeroDeIdentificacao(agencia.getNumeroDeIdentificacao())
                .email(agencia.getEmail())
                .build();
        return agenciaService.save(agencias);
    }
}

