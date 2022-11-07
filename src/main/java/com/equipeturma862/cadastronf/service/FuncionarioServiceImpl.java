package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.Funcionario;
import com.equipeturma862.cadastronf.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService{

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> list(String nome) {
        return IterableUtils.toList(funcionarioRepository.findAll());
    }

    @Override
    public Funcionario save(Funcionario funcionarios) {
        return funcionarioRepository.save(funcionarios);
    }

    @Override
    public Funcionario getById(Long id) {
        return funcionarioRepository.findById(id).get();

    }

    @Override
    public Funcionario update(Long id, Funcionario funcionarios) {
        funcionarios.setId(id);
        return funcionarioRepository.save(funcionarios);
    }

    @Override
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
