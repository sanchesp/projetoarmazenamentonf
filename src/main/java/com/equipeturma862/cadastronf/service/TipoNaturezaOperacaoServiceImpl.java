package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.TipoNaturezaOperacao;
import com.equipeturma862.cadastronf.repository.TipoNaturezaOperacaoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoNaturezaOperacaoServiceImpl implements TipoNaturezaOperacaoService {
    private final TipoNaturezaOperacaoRepository tipoNaturezaOperacaoRepository;

    @Override
    public List<TipoNaturezaOperacao> list(String nome) {
        return IterableUtils.toList(tipoNaturezaOperacaoRepository.findAll());
    }

    @Override
    public TipoNaturezaOperacao save(TipoNaturezaOperacao tipoNaturezaOperacao) {
        return tipoNaturezaOperacaoRepository.save(tipoNaturezaOperacao);
    }

    @Override
    public TipoNaturezaOperacao getById(Long id) {
        return tipoNaturezaOperacaoRepository.findById(id).get();
    }

    @Override
    public TipoNaturezaOperacao update(Long id, TipoNaturezaOperacao tipoNaturezaOperacao) {
        tipoNaturezaOperacao.setId(id);
        return tipoNaturezaOperacaoRepository.save(tipoNaturezaOperacao);
    }

    @Override
    public void delete(Long id) {
        tipoNaturezaOperacaoRepository.deleteById(id);
    }
}
