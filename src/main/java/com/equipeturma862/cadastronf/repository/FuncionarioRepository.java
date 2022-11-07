package com.equipeturma862.cadastronf.repository;

import com.equipeturma862.cadastronf.domain.Funcionario;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface FuncionarioRepository extends CrudRepository <Funcionario, Long> {
}
