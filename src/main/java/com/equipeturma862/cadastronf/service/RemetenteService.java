package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.Remetente;

import java.util.List;

public interface RemetenteService {
    List<Remetente> list(String nome);
    Remetente save(Remetente remetente);

    Remetente getById(Long id);

    Remetente update(Long id, Remetente remetente);

    void delete(Long id);
}
