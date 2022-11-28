package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.NotaFiscal;
import com.equipeturma862.cadastronf.domain.Remetente;
import com.equipeturma862.cadastronf.exceptions.NotaFiscalExists;
import com.equipeturma862.cadastronf.exceptions.NotaFiscalNotFound;
import com.equipeturma862.cadastronf.exceptions.RemetenteNotFound;
import com.equipeturma862.cadastronf.repository.NotasFiscaisRepositoy;
import com.equipeturma862.cadastronf.repository.RemetenteRepositoy;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaFiscalServiceImpl implements NotaFiscalService{


    private final NotasFiscaisRepositoy notasFiscaisRepositoy;
    private final RemetenteRepositoy remetenteRepositoy;


    @Override
    public List<NotaFiscal> list(String nome) {
        return IterableUtils.toList(notasFiscaisRepositoy.findAll());
    }

    @Override
    public NotaFiscal save(NotaFiscal notaFiscal, Long remetenteId) {
        if (remetenteRepositoy.existsById(remetenteId)) {
            if (notasFiscaisRepositoy.existsByNumeroNotaFiscal(notaFiscal.getNumeroNotaFiscal()) &&
                    notasFiscaisRepositoy.existsByDataEmissao(notaFiscal.getDataEmissao())) {
                throw new NotaFiscalExists();
            }else {
                    Remetente remetenteBuilder = Remetente.builder()
                            .id(remetenteId).build();
                    notaFiscal.setRemetente(remetenteBuilder);
                    return notasFiscaisRepositoy.save(notaFiscal);
                }
        }throw new RemetenteNotFound();
    }

    @Override
    public NotaFiscal getById(Long id) {
        if (notasFiscaisRepositoy.existsById(id)) {
            return notasFiscaisRepositoy.findById(id).get();
        }
        throw new NotaFiscalNotFound();
    }

    @Override
    public NotaFiscal update(Long id, NotaFiscal notaFiscal) {
        if (notasFiscaisRepositoy.existsById(id)) {
            notaFiscal.setId(id);
            return notasFiscaisRepositoy.save(notaFiscal);
        }
        throw new NotaFiscalNotFound();
    }

    @Override
    public void delete(Long id) {
        if (notasFiscaisRepositoy.existsById(id)) {
            notasFiscaisRepositoy.deleteById(id);
        } else {throw new NotaFiscalNotFound();}
    }
}
