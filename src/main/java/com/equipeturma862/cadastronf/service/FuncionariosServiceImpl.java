package com.equipeturma862.cadastronf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionariosServiceImpl implements FuncionariosService{

    private final CadastroNFRepository cadastroNFRepository;

    @Override
    public List<Funcionarios> list() {
        return IterableUtils.toList(cadastroNFRepository.findAll());
    }


    @Override
    public Funcionarios save(Funcionarios complexoEolico) {
        return cadastroNFRepository.save(complexoEolico);
    }

    @Override
    public Funcionarios getById(Long id) {
        return cadastroNFRepository.findById(id).get();

    }

    @Override
    public Funcionarios update(Long id, Funcionarios complexoEolico) {
        Funcionarios complexoEolicoUpdate = cadastroNFRepository.findById(id).get();
        complexoEolicoUpdate.setNome(complexoEolicoUpdate.getNome());
        return cadastroNFRepository.save(complexoEolicoUpdate);
    }

    @Override
    public void delete(Long id) {
        cadastroNFRepository.deleteById(id);
    }


}
