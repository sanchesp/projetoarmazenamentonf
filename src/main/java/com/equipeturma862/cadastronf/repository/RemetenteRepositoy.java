package com.equipeturma862.cadastronf.repository;

import com.equipeturma862.cadastronf.domain.Remetente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemetenteRepositoy extends CrudRepository<Remetente, Long> {
}
