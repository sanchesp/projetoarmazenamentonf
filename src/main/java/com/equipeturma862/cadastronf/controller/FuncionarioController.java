package com.equipeturma862.cadastronf.controller;

import com.equipeturma862.cadastronf.domain.Funcionario;
import com.equipeturma862.cadastronf.dto.FuncionarioDTO;
import com.equipeturma862.cadastronf.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("agencias/{agenciaId}/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    Funcionario save(@RequestBody @Valid FuncionarioDTO funcionarioDTO, @PathVariable Long agenciaId) {
        Funcionario funcionarioBuilder = Funcionario.builder()
                .nome(funcionarioDTO.getNome())
                .funcional(funcionarioDTO.getFuncional())
                .email(funcionarioDTO.getEmail())
                .build();
        return funcionarioService.save(funcionarioBuilder, agenciaId);
    }

    @GetMapping
    List<FuncionarioDTO> list(String nome) {

        List<Funcionario> list = funcionarioService.list(nome);

        return list.stream().map(funcionario -> FuncionarioDTO.builder()
                .nome(funcionario.getNome())
                .funcional(funcionario.getFuncional())
                .email(funcionario.getEmail()).build()).toList();
    }
    @GetMapping("{funcionarioId}")
    Funcionario getById(@PathVariable Long funcionarioId) {
        return funcionarioService.getById(funcionarioId);

    }
    @PutMapping("{funcionarioId}")
    Funcionario update(@PathVariable Long funcionarioId, @RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionarioBuilder = Funcionario.builder()
                .nome(funcionarioDTO.getNome())
                .funcional(funcionarioDTO.getFuncional())
                .email(funcionarioDTO.getEmail()).build();
        return funcionarioService.update(funcionarioId, funcionarioBuilder);
    }

    @DeleteMapping("{funcionarioId}")
    void delete(@PathVariable Long funcionarioId) {
        funcionarioService.delete(funcionarioId);
    }
}
