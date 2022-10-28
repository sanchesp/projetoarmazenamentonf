/*package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.repository.FuncionariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FuncionariosServiceImpl implements FuncionariosService{

    private final FuncionariosRepository funcionariosRepository;

    @Override
    public List<Funcionarios> list() {
        return IterableUtils.toList(funcionariosRepository.findAll());
    }


    @Override
    public Funcionarios save(Funcionarios funcionarios) {
        return funcionariosRepository.save(funcionarios);
    }

    @Override
    public Funcionarios getById(Long id) {
        return funcionariosRepository.findById(id).get();

    }

    @Override
    public Funcionarios update(Long id, Funcionarios funcionarios) {
        funcionarios.setId(id)
        return funcionariosRepository.save(funcionarios);
    }

    @Override
    public void delete(Long id) {
        funcionariosRepository.deleteById(id);
    }
}*/
