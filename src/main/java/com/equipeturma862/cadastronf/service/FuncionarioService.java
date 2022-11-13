package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.Funcionario;

import java.util.List;

public interface FuncionarioService {
    List<Funcionario> list(String nome);
    Funcionario save(Funcionario funcionario, Long agenciId);
    Funcionario getById(Long funcionarioId);
    Funcionario update(Long funcionarioid, Funcionario funcionario);
    void delete(Long id);
}
