package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.Agencia;

import java.util.List;

public interface AgenciaService {
    List<Agencia> list(String nome);
    Agencia save(Agencia agencia, Long agenciaId);

    Agencia getById(Long id);
    Agencia update(Long id, Agencia agencia);
    void delete(Long id);;
}
