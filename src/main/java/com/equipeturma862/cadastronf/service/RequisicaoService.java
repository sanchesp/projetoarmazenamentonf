package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.Requisicao;

import java.util.List;

public interface RequisicaoService {
	
	List <Requisicao> list (String nome);
	Requisicao save (Requisicao requisicao);
	Requisicao getById (Long id);
	Requisicao update (Long id, Requisicao requisicao);
	void delete (Long id);;

}
