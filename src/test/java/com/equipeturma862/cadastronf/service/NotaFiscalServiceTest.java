package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.builder.NotaFiscalBuilder;
import com.equipeturma862.cadastronf.domain.NotaFiscal;
import com.equipeturma862.cadastronf.repository.NotasFiscaisRepositoy;
import com.equipeturma862.cadastronf.repository.RemetenteRepositoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

public class NotaFiscalServiceTest {

    @Mock
    private NotasFiscaisRepositoy notasFiscaisRepositoy;

    @Mock
    private RemetenteRepositoy remetenteRepositoy;

    @Mock
    private RequisicaoService requisicaoService;

    @Autowired
    @InjectMocks
    private NotaFiscalServiceImpl notaFiscalService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("Não pode receber numeros de NF iguais")
    public void numeroDeNFIguais (){
        //Given

        NotaFiscal notaFiscal1 = NotaFiscalBuilder.retornaNotaFiscalBuilder().get();

        //When
        Mockito.when(remetenteRepositoy.existsById(1L)).thenReturn(true);
        Mockito.when(notasFiscaisRepositoy.save(Mockito.any(NotaFiscal.class))).thenReturn();
        NotaFiscal notaFiscalSave = notaFiscalService.save(notaFiscal1,1L);
        //Then
        Assertions.assertNotNull(notaFiscalSave);
    }

}
