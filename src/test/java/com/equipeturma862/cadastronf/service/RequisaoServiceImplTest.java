package com.equipeturma862.cadastronf.service;


import com.equipeturma862.cadastronf.builder.RequisicaoBuider;
import com.equipeturma862.cadastronf.domain.Requisicao;
import com.equipeturma862.cadastronf.repository.NotasFiscaisRepositoy;
import com.equipeturma862.cadastronf.repository.RequisicaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class RequisaoServiceImplTest {

    @Mock
    private RequisicaoRepository requisicaoRepository;

    @Mock
    private NotasFiscaisRepositoy notasFiscaisRepositoy;

    @InjectMocks
    private RequisicaoServiceImpl requisicaoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Deve salvar uma requisição")
    public void deveSalvarUmaRequisicao() {
        //Given
        Requisicao requisicao = RequisicaoBuider.retornarRequisicaoBuilder().get();
        //When
        Mockito.when(requisicaoRepository.existsById(ArgumentMatchers.any())).thenReturn(true);

        Mockito.when(requisicaoRepository.save(ArgumentMatchers.any(Requisicao.class))).thenReturn(requisicao);
        //Then
        Requisicao requisicaoSave = requisicaoService.save(requisicao);
        Assertions.assertEquals(requisicao, requisicaoSave);
        Mockito.verify(requisicaoRepository, Mockito.times(1)).save(ArgumentMatchers.any(Requisicao.class));

    }
}