package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.Agencia;
import com.equipeturma862.cadastronf.repository.AgenciaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class AgenciaServiceTest {

    @Mock
    private AgenciaRepository agenciaRepository;

    @InjectMocks
    private AgenciaServiceImpl agenciaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void DeveSalvarOCadastroDeUmaAgenciaQuandoNaoExistirONumeroDeIdentificacao() {
        //Given
        Agencia agenciaMock = Mockito.mock(Agencia.class);

        //When
        Mockito.when(agenciaRepository.existsByNumeroDeIdentificacao(ArgumentMatchers.any())).thenReturn(false);
        Mockito.when(agenciaRepository.save(ArgumentMatchers.any(Agencia.class))).thenReturn(agenciaMock);

        //Then
        Agencia agenciaSaveTest = agenciaService.save(agenciaMock);

        Assertions.assertEquals(agenciaMock, agenciaSaveTest);

        Mockito.verify(agenciaRepository, Mockito.times(1)).existsByNumeroDeIdentificacao(ArgumentMatchers.any());
    }
}
