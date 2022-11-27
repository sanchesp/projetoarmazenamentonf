package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.ClassificacaoPessoa;
import com.equipeturma862.cadastronf.domain.NotaFiscal;
import com.equipeturma862.cadastronf.domain.Remetente;
import com.equipeturma862.cadastronf.exceptions.NotaFiscalExists;
import com.equipeturma862.cadastronf.exceptions.RemetenteNotFound;
import com.equipeturma862.cadastronf.exceptions.ValidationRequired;
import com.equipeturma862.cadastronf.repository.NotasFiscaisRepositoy;
import com.equipeturma862.cadastronf.repository.RemetenteRepositoy;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Remetente> remetente = remetenteRepositoy.findById(remetenteId);

        if (!remetente.isEmpty()) {
           if(remetente.get().getTipoDePessoa()==ClassificacaoPessoa.PESSOA_JURRIDICA &&
                   (notaFiscal.getNumeroNotaFiscal() == null || notaFiscal.getTipoNaturezaOperacao() == null)) {
                    throw new ValidationRequired();
           }

            if (notasFiscaisRepositoy.existsByNumeroNotaFiscal(notaFiscal.getNumeroNotaFiscal()) &&
                    notasFiscaisRepositoy.existsByDataEmissao(notaFiscal.getDataEmissao()))
            {
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
        return notasFiscaisRepositoy.findById(id).get();
    }

    @Override
    public NotaFiscal update(Long id, NotaFiscal notaFiscal) {
        notaFiscal.setId(id);
        return notasFiscaisRepositoy.save(notaFiscal);
    }

    @Override
    public void delete(Long id) {
        notasFiscaisRepositoy.deleteById(id);

    }
}
