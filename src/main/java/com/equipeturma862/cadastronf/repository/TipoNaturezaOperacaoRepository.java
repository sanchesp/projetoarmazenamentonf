package com.equipeturma862.cadastronf.repository;

import com.equipeturma862.cadastronf.domain.TipoNaturezaOperacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoNaturezaOperacaoRepository extends CrudRepository<TipoNaturezaOperacao, Long> {
}
