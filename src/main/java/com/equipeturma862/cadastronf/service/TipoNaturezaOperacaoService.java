package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.TipoNaturezaOperacao;

import java.util.List;

public interface TipoNaturezaOperacaoService {
    List<TipoNaturezaOperacao> list (String nome);

    TipoNaturezaOperacao save(TipoNaturezaOperacao tipoNaturezaOperacao);

    TipoNaturezaOperacao getById(Integer id);

    TipoNaturezaOperacao update(Integer id, TipoNaturezaOperacao tipoNaturezaOperacao);

    void delete(Integer id);
}
