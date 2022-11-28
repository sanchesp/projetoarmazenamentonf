package com.equipeturma862.cadastronf.builder;

import com.equipeturma862.cadastronf.domain.Funcionario;
import com.equipeturma862.cadastronf.domain.NotaFiscal;
import com.equipeturma862.cadastronf.domain.Requisicao;
import java.time.LocalDateTime;


public class RequisicaoBuilder {

    private static Requisicao requisicao;

    public static RequisicaoBuilder retornarRequisicaoBuilder () {
        RequisicaoBuilder requisicaoBuilder = new RequisicaoBuilder();
        requisicaoBuilder.requisicao = new Requisicao(1l,LocalDateTime.now(), "Detalhe do Trajeto", 1L, Funcionario.builder().build(), NotaFiscal.builder().build() );
        return requisicaoBuilder;
    }

    public Requisicao get() {
        return requisicao;
    }
}
