package com.equipeturma862.cadastronf.service;
import com.equipeturma862.cadastronf.domain.Agencia;
import com.equipeturma862.cadastronf.domain.ClassificacaoPessoa;
import com.equipeturma862.cadastronf.domain.Remetente;
import com.equipeturma862.cadastronf.exceptions.*;
import com.equipeturma862.cadastronf.repository.AgenciaRepository;
import com.equipeturma862.cadastronf.repository.RemetenteRepositoy;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RemetenteServiceImpl implements RemetenteService{
    private final RemetenteRepositoy remetenteRepository;

    private final AgenciaRepository agenciaRepository;


    @Override
    public List<Remetente> list(String nome) {
        return IterableUtils.toList(remetenteRepository.findAll());
    }

    @Override
    public Remetente save(Remetente remetente, Long agenciaId) {
        if (agenciaRepository.existsById(agenciaId)){
            if(remetenteRepository.existCPF(remetente.getCPF()) &&
                    remetenteRepository.existCNPJ(remetente.getCNPJ())) {
                throw new RemetenteExists();
            } else {
                Remetente remetenteBuilder = Remetente
                        .builder()
                        .id(agenciaId)
                        .build();
                remetente.setAgencia(Agencia.builder().build());
                return remetenteRepository.save(remetente);
            }
        } else {
            throw new RemetenteNotFound();
        }
    }



    @Override
    public Remetente getById(Long id) {
        return remetenteRepository.findById(id).get();
    }

    @Override
    public Remetente update(Long id, Remetente remetente) {
        remetente.setId(Long.valueOf(id));
        return remetenteRepository.save(remetente);
    }

    @Override
    public void delete(Long id) {
        remetenteRepository.deleteById(id);
    }
}
