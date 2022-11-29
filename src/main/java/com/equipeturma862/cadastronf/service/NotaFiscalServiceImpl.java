package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.NotaFiscal;
import com.equipeturma862.cadastronf.domain.Remetente;
import com.equipeturma862.cadastronf.exceptions.NotaFiscalExists;
import com.equipeturma862.cadastronf.exceptions.NotaFiscalNotFound;
import com.equipeturma862.cadastronf.exceptions.RemetenteNotFound;
import com.equipeturma862.cadastronf.repository.NotasFiscaisRepository;
import com.equipeturma862.cadastronf.repository.RemetenteRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaFiscalServiceImpl implements NotaFiscalService{


    private final NotasFiscaisRepository notasFiscaisRepository;
    private final RemetenteRepository remetenteRepository;


    @Override
    public List<NotaFiscal> list(String nome) {
        return IterableUtils.toList(notasFiscaisRepository.findAll());
    }

    @Override
    public NotaFiscal save(NotaFiscal notaFiscal, Long remetenteId) {
        if (remetenteRepository.existsById(remetenteId)) {
            if (notasFiscaisRepository.existsByNumeroNotaFiscal(notaFiscal.getNumeroNotaFiscal()) &&
                    notasFiscaisRepository.existsByDataEmissao(notaFiscal.getDataEmissao())) {
                throw new NotaFiscalExists();
            }else {
                    Remetente remetenteBuilder = Remetente
                            .builder()
                            .id(remetenteId)
                            .build();
                    notaFiscal.setRemetente(remetenteBuilder);
                    return notasFiscaisRepository.save(notaFiscal);
                }
        }throw new RemetenteNotFound();
    }

    @Override
    public NotaFiscal getById(Long id) {
        if (notasFiscaisRepository.existsById(id)) {
            return notasFiscaisRepository.findById(id).get();
        }
        throw new NotaFiscalNotFound();
    }

    @Override
    public NotaFiscal update(Long id, NotaFiscal notaFiscal) {
        if (notasFiscaisRepository.existsById(id)) {
            notaFiscal.setId(id);
            return notasFiscaisRepository.save(notaFiscal);
        }
        throw new NotaFiscalNotFound();
    }

    @Override
    public void delete(Long id) {
        if (notasFiscaisRepository.existsById(id)) {
            notasFiscaisRepository.deleteById(id);
        } else {
            throw new NotaFiscalNotFound();}
    }
}
