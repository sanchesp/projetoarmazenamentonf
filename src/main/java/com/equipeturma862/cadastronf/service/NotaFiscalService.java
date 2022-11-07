package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.NotaFiscal;

import java.util.List;

public interface NotaFiscalService {

    List<NotaFiscal> list(String nome);
    NotaFiscal save(NotaFiscal notaFiscal);
    NotaFiscal getById(Integer id);
    NotaFiscal update(Integer id, NotaFiscal notaFiscal);
    void delete(Integer id);
}
