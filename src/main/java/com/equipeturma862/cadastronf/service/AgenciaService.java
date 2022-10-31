package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.Agencia;

import java.util.List;

public interface AgenciaService {
    List<Agencia> list(String nome);
    Agencia save(Agencia agencia);
    Agencia getById(Integer id);
    Agencia update(Integer id, Agencia agencia);
    void delete(Integer id);;
}
