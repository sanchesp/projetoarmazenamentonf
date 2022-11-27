package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.builder.NotaFiscalBuilder;
import com.equipeturma862.cadastronf.domain.NotaFiscal;
import com.equipeturma862.cadastronf.repository.NotasFiscaisRepositoy;
import com.equipeturma862.cadastronf.repository.RemetenteRepositoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
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
    @DisplayName("Deve salvar uma nota fiscal quando houve remetente cadastrado e não houve um numero de nota fiscal cadastrada para esse remetente")
    public void deveSalvarUmaNotaFiscal (){
        //Given

        NotaFiscal notaFiscal = Mockito.mock(NotaFiscal.class);

        //When
        Mockito.when(remetenteRepositoy.existsById((ArgumentMatchers.any())).theReturn(true);
        Mockito.when(notasFiscaisRepositoy.existsByNumeroNotaFiscal(ArgumentMatchers.any())).thenReturn(false);

        //Then
        notaFiscalService.save(notaFiscal, 1L);
        Mockito.verify(remetenteRepositoy, Mockito.times(1)).existsById(ArgumentMatchers.any());
        Mockito.verify(notasFiscaisRepositoy, Mockito.times(1)).save(ArgumentMatchers.any(NotaFiscal.class));
        Mockito.verify(notasFiscaisRepositoy, Mockito.times(1)).existsByNumeroNotaFiscal(ArgumentMatchers.any());
        Mockito.verify(notasFiscaisRepositoy, Mockito.never()).existsByDataEmissao(ArgumentMatchers.any());

    }

}
