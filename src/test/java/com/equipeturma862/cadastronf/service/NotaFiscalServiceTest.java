package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.builder.NotaFiscalBuilder;
import com.equipeturma862.cadastronf.domain.NotaFiscal;
import com.equipeturma862.cadastronf.exceptions.NotaFiscalExists;
import com.equipeturma862.cadastronf.exceptions.NotaFiscalNotFound;
import com.equipeturma862.cadastronf.exceptions.RemetenteNotFound;
import com.equipeturma862.cadastronf.repository.NotasFiscaisRepository;
import com.equipeturma862.cadastronf.repository.RemetenteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class NotaFiscalServiceTest {

    @Mock
    private NotasFiscaisRepository notasFiscaisRepository;

    @Mock
    private RemetenteRepository remetenteRepository;

    @InjectMocks
    private NotaFiscalServiceImpl notaFiscalService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("Deve salvar uma nota fiscal quando houve remetente cadastrado e não houve um numero de nota fiscal cadastrada para esse remetente")
    public void deveSalvarUmaNotaFiscalQuandoHouverUmRemetenteCadastradoENaoExisterONumeroDaNF  () {
        //Given
        NotaFiscal notaFiscal = NotaFiscalBuilder.retornaNotaFiscalBuilder().get();
        //When
        Mockito.when(remetenteRepository.existsById(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(notasFiscaisRepository.existsByNumeroNotaFiscal(ArgumentMatchers.any())).thenReturn(false);
        Mockito.when(notasFiscaisRepository.existsByDataEmissao(ArgumentMatchers.any())).thenReturn(false);
        Mockito.when(notasFiscaisRepository.save(ArgumentMatchers.any(NotaFiscal.class))).thenReturn(notaFiscal);
        //Then

        NotaFiscal notaFiscalSave =  notaFiscalService.save(notaFiscal, 1l);

        Assertions.assertEquals(notaFiscal,notaFiscalSave);

        Mockito.verify(remetenteRepository, Mockito.times(1)).existsById(ArgumentMatchers.any());
        Mockito.verify(notasFiscaisRepository, Mockito.times(1)).save(ArgumentMatchers.any(NotaFiscal.class));
        Mockito.verify(notasFiscaisRepository, Mockito.times(1)).existsByNumeroNotaFiscal(ArgumentMatchers.any());
        Mockito.verify(notasFiscaisRepository, Mockito.never()).existsByDataEmissao(ArgumentMatchers.any());
    }
    @Test
    @DisplayName("Deve salvar uma nota fiscal quando houve remetente cadastrado, e quando existir um numero de Nota Fiscal poém com data de emissão diferente para esse remetente")
    public void deveSalvarUmaNotaFiscalQuandoHouverUmRemetenteCadastradoENaoExistirOsDadosDaNF() {
        //Given
        NotaFiscal notaFiscal = Mockito.mock(NotaFiscal.class);
        //When
        Mockito.when(remetenteRepository.existsById(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(notasFiscaisRepository.existsByNumeroNotaFiscal(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(notasFiscaisRepository.existsByDataEmissao(ArgumentMatchers.any())).thenReturn(false);
        Mockito.when(notasFiscaisRepository.save(ArgumentMatchers.any(NotaFiscal.class))).thenReturn(notaFiscal);
        //Then
        NotaFiscal notaFiscalSave =  notaFiscalService.save(notaFiscal, 1l);

        Assertions.assertEquals(notaFiscal,notaFiscalSave);

        Mockito.verify(remetenteRepository, Mockito.times(1)).existsById(ArgumentMatchers.any());
        Mockito.verify(notasFiscaisRepository, Mockito.times(1)).save(ArgumentMatchers.any(NotaFiscal.class));
        Mockito.verify(notasFiscaisRepository, Mockito.times(1)).existsByNumeroNotaFiscal(ArgumentMatchers.any());
        Mockito.verify(notasFiscaisRepository, Mockito.times(1)).existsByDataEmissao(ArgumentMatchers.any());
    }

    @Test
    @DisplayName("Deve lançar um exception quando não houve remetente cadastrado")
    public void deveLancarExceptionQuandoNaoHouverRemetenteCadastrado() {
        //Given
        NotaFiscal notaFiscal = NotaFiscalBuilder.retornaNotaFiscalBuilder().get();
        //When
        Mockito.when(remetenteRepository.existsById(ArgumentMatchers.any())).thenReturn(false);

        //Then
        Assertions.assertThrows(RemetenteNotFound.class, () -> notaFiscalService.save(ArgumentMatchers.any(NotaFiscal.class),1L));
        Mockito.verify(remetenteRepository, Mockito.times(1)).existsById(ArgumentMatchers.any());
        Mockito.verify(notasFiscaisRepository, Mockito.never()).save(ArgumentMatchers.any(NotaFiscal.class));
        Mockito.verify(notasFiscaisRepository, Mockito.never()).existsByNumeroNotaFiscal(ArgumentMatchers.any());
        Mockito.verify(notasFiscaisRepository, Mockito.never()).existsByDataEmissao(ArgumentMatchers.any());
    }
    @Test
    @DisplayName("Deve lançar um exception quando já existir numero e data de emissão da nota fiscal já cadastrados para o remetente")
    public void deveLancarExceptionQuandoExistirANFCadastradaParaORemetente() {
        //Given
        NotaFiscal notaFiscal = Mockito.mock(NotaFiscal.class);

        //When
        Mockito.when(remetenteRepository.existsById(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(notasFiscaisRepository.existsByNumeroNotaFiscal(Mockito.any())).thenReturn(true);
        Mockito.when(notasFiscaisRepository.existsByDataEmissao(ArgumentMatchers.any())).thenReturn(true);

        //Then
        Assertions.assertThrows(NotaFiscalExists.class, () -> notaFiscalService.save(notaFiscal,1L));

    }

    @Test
    public void DeveUtualizarOsDadosDaNFSeExistirOID(){
        //Given
        NotaFiscal notaFiscal = Mockito.mock(NotaFiscal.class);

        //When
        Mockito.when(notasFiscaisRepository.existsById(notaFiscal.getId())).thenReturn(false);

        //Then
        Assertions.assertThrows(NotaFiscalNotFound.class, () -> notaFiscalService.getById(1L));
    }
}