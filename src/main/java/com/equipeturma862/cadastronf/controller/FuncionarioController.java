package com.equipeturma862.cadastronf.controller;

import com.equipeturma862.cadastronf.domain.Funcionario;
import com.equipeturma862.cadastronf.dto.FuncionarioDTO;
import com.equipeturma862.cadastronf.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("agencias/{agenciaID}/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    Funcionario save(@RequestBody @Valid FuncionarioDTO funcionario, @PathVariable Long agenciaID) {
        Funcionario funcionarioBuilder = Funcionario.builder()
                .nome(funcionario.getNome())
                .funcional(funcionario.getFuncional())
                .email(funcionario.getEmail()).build();
        return funcionarioService.save(funcionarioBuilder);
    }

    @GetMapping
    List<FuncionarioDTO> list(String nome) {

        List<Funcionario> list = funcionarioService.list(nome);

        return list.stream().map(funcionario -> FuncionarioDTO.builder()
                .nome(funcionario.getNome())
                .id(funcionario.getId())
                .funcional(funcionario.getFuncional())
                .email(funcionario.getEmail()).build()).toList();
    }
}
