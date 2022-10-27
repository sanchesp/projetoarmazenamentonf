package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.repository.FuncionariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionariosServiceImpl implements FuncionariosService{

    private final FuncionariosRepository funcionariosRepository;

    @Override
    public List<Funcionarios> list() {
        return IterableUtils.toList(funcionariosRepository.findAll());
    }


    @Override
    public Funcionarios save(Funcionarios complexoEolico) {
        return funcionariosRepository.save(complexoEolico);
    }

    @Override
    public Funcionarios getById(Long id) {
        return funcionariosRepository.findById(id).get();

    }

    @Override
    public Funcionarios update(Long id, Funcionarios complexoEolico) {
        Funcionarios complexoEolicoUpdate = funcionariosRepository.findById(id).get();
        complexoEolicoUpdate.setNome(complexoEolicoUpdate.getNome());
        return funcionariosRepository.save(complexoEolicoUpdate);
    }

    @Override
    public void delete(Long id) {
        funcionariosRepository.deleteById(id);
    }


}
