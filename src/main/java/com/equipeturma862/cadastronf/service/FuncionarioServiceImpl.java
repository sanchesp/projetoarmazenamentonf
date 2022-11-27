package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.Agencia;
import com.equipeturma862.cadastronf.domain.Funcionario;
import com.equipeturma862.cadastronf.exceptions.AgenciaNotFound;
import com.equipeturma862.cadastronf.exceptions.FuncionarioExists;
import com.equipeturma862.cadastronf.repository.AgenciaRepository;
import com.equipeturma862.cadastronf.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService{

    private final FuncionarioRepository funcionarioRepository;
    private final AgenciaRepository agenciaRepository;

    @Override
    public List<Funcionario> list(String nome) {
        return IterableUtils.toList(funcionarioRepository.findAll());
    }

    @Override
    public Funcionario save(Funcionario funcionario, Long agenciaId) {
        if (agenciaRepository.existsById(agenciaId)){
            if(funcionarioRepository.existByFuncional(funcionario.getFuncional())) {
                throw new FuncionarioExists();
            } else if(funcionarioRepository.existByEmail(funcionario.getEmail())){
                throw new FuncionarioExists();
            } else {
                Agencia agenciaBuilder = Agencia.builder()
                .id(agenciaId).build();
                funcionario.setAgencia(agenciaBuilder);
                return funcionarioRepository.save(funcionario);
            }
        } else {
            throw new AgenciaNotFound();
        }
    }

    @Override
    public Funcionario getById(Long funcionarioId) {
        return funcionarioRepository.findById(funcionarioId).get();
    }

    @Override
    public Funcionario update(Long funcionarioId, Funcionario funcionario) {
        funcionario.setId(funcionarioId);
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void delete(Long funcionarioId) {
        funcionarioRepository.deleteById(funcionarioId);
    }
}
