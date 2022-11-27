package com.equipeturma862.cadastronf.repository;

import com.equipeturma862.cadastronf.domain.NotaFiscal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface NotasFiscaisRepositoy extends CrudRepository<NotaFiscal, Long> {

    boolean existsByNumeroNotaFiscal(Long numeroNotaFiscal);
    boolean existsByDataEmissao(LocalDate dataEmisao);


}
