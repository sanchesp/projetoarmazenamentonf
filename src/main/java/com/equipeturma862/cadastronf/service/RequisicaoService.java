package service;

import java.util.List;

import domain.Requisicao;

public interface RequisicaoService {
	
	List <Requisicao> list (String nome);
	Requisicao save (Requisicao requisicao);
	Requisicao getById (Integer id);
	Requisicao update (Integer id, Requisicao requisicao);
	void delete (Integer id);;

}
