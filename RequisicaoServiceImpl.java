package service;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import domain.Requisicao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class RequisicaoServiceImpl implements RequisicaoService {
	
   private final RequisicaoRepository requisicaoRepository;

	    @Override
	    public List<Requisicao> list (String nome) {
	        return IterableUtils.toList(requisicaoRepository.findAll());
	    }

	    @Override
	    public Requisicao save(Requisicao requisicao) {
	        return requisicaoRepository.save(requisicao);
	    }

	    @Override
	    public Requisicao getById(Integer id) {
	        return requisicaoRepository.findById(id).get();
	    }

	    @Override
	    public Requisicao update(Integer id, Requisicao requisicao) {
	        requisicao.setId(id);
	        return requisicaoRepository.save(requisicao);
	    }

	    @Override
	    public void delete(Integer id) {
	    	requisicaoRepository.deleteById(id);
	    }

		@Override
		public Requisicao save(Requisicao requisicao) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Requisicao getById(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Requisicao update(Integer id, Requisicao requisicao) {
			// TODO Auto-generated method stub
			return null;
		}
	   
}
