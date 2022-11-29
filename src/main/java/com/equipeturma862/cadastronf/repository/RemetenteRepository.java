package com.equipeturma862.cadastronf.repository;

import com.equipeturma862.cadastronf.domain.Remetente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemetenteRepository extends CrudRepository<Remetente, Long> {

    boolean existsByCPF (String cpf);
    boolean existsByCNPJ (String cnpj);
    boolean existsById (Long id);


}
