package com.equipeturma862.cadastronf.service;


import com.equipeturma862.cadastronf.builder.RequisicaoBuilder;
import com.equipeturma862.cadastronf.domain.Requisicao;
import com.equipeturma862.cadastronf.exceptions.RequisicaoNotFound;
import com.equipeturma862.cadastronf.repository.RequisicaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class RequisaoServiceImplTest {



    @InjectMocks
    private RequisicaoServiceImpl requisicaoService;
    @Mock
    private RequisicaoRepository requisicaoRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("Deve salvar uma requisição")
    public void deveSalvarUmaRequisicao() {
        //Given
        Requisicao requisicao = RequisicaoBuilder.retornarRequisicaoBuilder().get();
        //When
        Mockito.when(requisicaoRepository.existsById(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(requisicaoRepository.save(ArgumentMatchers.any(Requisicao.class))).thenReturn(requisicao);
        //Then
        Requisicao requisicaoSave = requisicaoService.save(requisicao);
        Assertions.assertEquals(requisicao, requisicaoSave);
        Mockito.verify(requisicaoRepository, Mockito.times(1)).save(ArgumentMatchers.any(Requisicao.class));

    }

    @Test
    @DisplayName("deveLancarUmaExceptionQuandoIdNaoEncontradoUpdate")
    public void deveLancarUmaExceptionQuandoIdNaoEncontradoUpdate() {

        Requisicao requisicao = RequisicaoBuilder.retornarRequisicaoBuilder().get();
        Throwable throwable = Assertions.assertThrows(RequisicaoNotFound.class,
                () -> requisicaoService.update(1L,requisicao ));

        Assertions.assertEquals("Requisição não localizada", throwable.getMessage());
    }

    @Test
    @DisplayName("deveLancarUmaExceptionQuandoIdNaoEncontradoDelete")
    public void deveLancarUmaExceptionQuandoIdNaoEncontradoDelete() {

        Requisicao requisicao = RequisicaoBuilder.retornarRequisicaoBuilder().get();
        Throwable throwable = Assertions.assertThrows(RequisicaoNotFound.class,
                () -> requisicaoService.delete(1L));

        Assertions.assertEquals("Requisição não localizada", throwable.getMessage());
    }
}