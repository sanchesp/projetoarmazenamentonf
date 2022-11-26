package com.equipeturma862.cadastronf.builder;

import com.equipeturma862.cadastronf.domain.Funcionario;
import com.equipeturma862.cadastronf.domain.NotaFiscal;
import com.equipeturma862.cadastronf.domain.Requisicao;
import java.time.LocalDateTime;


public class RequisicaoBuider {

    private static Requisicao requisicao;

    public static RequisicaoBuider retornarRequisicaoBuilder () {
        RequisicaoBuider requisicaoBuider = new RequisicaoBuider();
        requisicaoBuider.requisicao = new Requisicao(1l,LocalDateTime.now(), "Detalhe do Trajeto", 1L, Funcionario.builder().build(), NotaFiscal.builder().build() );
        return requisicaoBuider;
    }

    public Requisicao get() {
        return requisicao;
    }
}
