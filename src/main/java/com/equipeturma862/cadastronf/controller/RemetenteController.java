package com.equipeturma862.cadastronf.controller;

import com.equipeturma862.cadastronf.domain.Remetente;
import com.equipeturma862.cadastronf.dto.RemetenteDTO;
import com.equipeturma862.cadastronf.service.RemetenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("remetente")
@RequiredArgsConstructor
public class RemetenteController {

    private final RemetenteService remetenteService;
    @GetMapping
    List<RemetenteDTO> list(String nome) {

        List<Remetente> list = remetenteService.list(nome);

        return list.stream().map(remetente -> RemetenteDTO.builder()
                .id(remetente.getId())
                .tipoDePessoa(remetente.getTipoDePessoa())
                .CNPJ(remetente.getCNPJ())
                .razaoSocial(remetente.getRazaoSocial())
                .telefone(remetente.getTelefone()).build()).toList();
    }
    @GetMapping("{remetenteId}")
    Remetente getById(@PathVariable Long remetenteId) {
        return remetenteService.getById(remetenteId);
    }
    @PostMapping
    Remetente save(@RequestBody @Valid RemetenteDTO remetenteDTO) {
        Remetente remetenteBuilder = Remetente.builder()
                .id(remetenteDTO.getId())
                .tipoDePessoa(remetenteDTO.getTipoDePessoa())
                .CNPJ(remetenteDTO.getCNPJ())
                .razaoSocial(remetenteDTO.getRazaoSocial())
                .telefone(remetenteDTO.getTelefone())
                .build();
        return remetenteService.save(remetenteBuilder);
    }

    @PutMapping("remetente/{remetenteId}")
    Remetente update(@PathVariable Long remetenteId, @RequestBody RemetenteDTO remetenteDTO) {
        Remetente remetenteBuilder = Remetente.builder()
                .id(remetenteDTO.getId())
                .tipoDePessoa(remetenteDTO.getTipoDePessoa())
                .CNPJ(remetenteDTO.getCNPJ())
                .razaoSocial(remetenteDTO.getRazaoSocial())
                .telefone(remetenteDTO.getTelefone())
                .build();
        return remetenteService.update(remetenteId, remetenteBuilder);
    }

    @DeleteMapping("remetente/{remetenteId}")
    void delete(@PathVariable Long remetenteId) {
        remetenteService.delete(remetenteId);
    }
}

