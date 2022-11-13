package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.NotaFiscal;

import java.util.List;

public interface NotaFiscalService {

    List<NotaFiscal> list(String nome);
    NotaFiscal save(NotaFiscal notaFiscal, Long remetenteId);
    NotaFiscal getById(Long id);
    NotaFiscal update(Long id, NotaFiscal notaFiscal);
    void delete(Long id);
}
