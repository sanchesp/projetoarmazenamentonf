package com.equipeturma862.cadastronf.builder;

import com.equipeturma862.cadastronf.domain.Remetente;

import static com.equipeturma862.cadastronf.domain.ClassificacaoPessoa.PESSOA_FISICA;

public class RemetenteBuilder {

    private static Remetente remetente;

    public static RemetenteBuilder retornarRemetenteBuilder () {
        RemetenteBuilder remetenteBuilder = new RemetenteBuilder();
        remetenteBuilder.remetente = new Remetente(1L, PESSOA_FISICA, "CNPJ", "razaoSocial", "telefone");
        return remetenteBuilder;
    }
}
