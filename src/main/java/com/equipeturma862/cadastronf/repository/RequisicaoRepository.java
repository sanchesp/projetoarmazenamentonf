package com.equipeturma862.cadastronf.repository;

import com.equipeturma862.cadastronf.domain.Requisicao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoRepository extends CrudRepository<Requisicao, Long> {
}
