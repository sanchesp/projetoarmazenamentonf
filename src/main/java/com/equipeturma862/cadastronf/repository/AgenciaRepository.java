package com.equipeturma862.cadastronf.repository;

import com.equipeturma862.cadastronf.domain.Agencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends CrudRepository<Agencia, Long > {

    boolean existsByNumeroDeIdentificacao (Long numeroDeIdentificacao);
}
