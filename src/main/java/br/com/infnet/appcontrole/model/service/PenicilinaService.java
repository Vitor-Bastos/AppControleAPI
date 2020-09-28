package br.com.infnet.appcontrole.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.infnet.appcontrole.model.negocio.Penicilina;
import br.com.infnet.appcontrole.model.repository.IPenicilinaRepository;

@Service
public class PenicilinaService {

	@Autowired private IPenicilinaRepository penicilinaRepository;
	
	public List<Penicilina> obterLista(){
		return (List<Penicilina>)penicilinaRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
	}
	
	public void incluir(Penicilina penicilina) {
		penicilinaRepository.save(penicilina);
	}

	public void excluir(Integer id) {
		penicilinaRepository.deleteById(id);		
	}

	public Penicilina obterPorId(Integer id) {
		return penicilinaRepository.findById(id).orElse(null);
	}
}