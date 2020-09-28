package br.com.infnet.appcontrole.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.infnet.appcontrole.model.negocio.Insulina;
import br.com.infnet.appcontrole.model.repository.IInsulinaRepository;

@Service
public class InsulinaService {

	@Autowired private IInsulinaRepository insulinaRepository;
	
	public List<Insulina> obterLista(){
		return (List<Insulina>)insulinaRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
	}
	
	public void incluir(Insulina insulina) {
		insulinaRepository.save(insulina);
	}

	public void excluir(Integer id) {
		insulinaRepository.deleteById(id);		
	}

	public Insulina obterPorId(Integer id) {
		return insulinaRepository.findById(id).orElse(null);
	}
}