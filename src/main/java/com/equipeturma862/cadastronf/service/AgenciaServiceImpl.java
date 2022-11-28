package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.Agencia;
import com.equipeturma862.cadastronf.exceptions.AgenciaExists;
import com.equipeturma862.cadastronf.exceptions.AgenciaNotFound;
import com.equipeturma862.cadastronf.repository.AgenciaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenciaServiceImpl implements AgenciaService {

    private final AgenciaRepository agenciaRepository;

    @Override
    public List<Agencia> list(String nome) {
        return IterableUtils.toList(agenciaRepository.findAll( ));
    }

    @Override
    public Agencia save(Agencia agencia) {
        if(agenciaRepository.existsByNumeroDeIdentificacao(agencia.getNumeroDeIdentificacao())){
            throw new AgenciaExists();
        }
        return agenciaRepository.save(agencia);
    }

    @Override
    public Agencia getById(Long id) {
        Agencia ag = new Agencia( );
         if (ag.getNumeroDeIdentificacao( ) == null) ;
        return agenciaRepository.findById(id).orElseThrow(AgenciaNotFound::new);
}

    @Override
    public Agencia update(Long id, Agencia agencia) {
        agencia.setId(id);
        return agenciaRepository.save(agencia);
    }

    @Override
    public void delete(Long id) {
        agenciaRepository.deleteById(id);
    }
}
