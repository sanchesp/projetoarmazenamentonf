package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.Funcionario;

import java.util.List;

public interface FuncionarioService {
    List<Funcionario> list(String nome);
    Funcionario save(Funcionario funcionario);
    Funcionario getById(Long id);
    Funcionario update(Long id, Funcionario funcionario);
    void delete(Long id);
}
