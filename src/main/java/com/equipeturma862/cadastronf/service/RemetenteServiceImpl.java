
package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.Remetente;
import com.equipeturma862.cadastronf.exceptions.AgenciaNotFound;
import com.equipeturma862.cadastronf.exceptions.RemetenteExists;
import com.equipeturma862.cadastronf.exceptions.RemetenteNotFound;
import com.equipeturma862.cadastronf.repository.AgenciaRepository;
import com.equipeturma862.cadastronf.repository.RemetenteRepositoy;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
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
    public Remetente save(Remetente remetente) {
        if(remetenteRepository.existsByCPF(remetente.getCPF()) &&
                remetenteRepository.existsByCNPJ(remetente.getCNPJ())) {
                throw new RemetenteExists();
            } else {
            return remetenteRepository.save(remetente);
            }
    }



    @Override
    public Remetente getById(Long id) {
        return remetenteRepository.findById(id).get();
    }

    @Override
    public Remetente update(Long id, Remetente remetente) {
        if(remetenteRepository.existsById(id)) {
            remetente.setId(id);
            return remetenteRepository.save(remetente);
        } throw new RemetenteNotFound();
    }

    @Override
    public void delete(Long id) {
        if(remetenteRepository.existsById(id)) {
            remetenteRepository.deleteById(id);
        }
        throw new RemetenteNotFound();
    }
}
