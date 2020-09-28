package br.com.infnet.appcontrole.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.infnet.appcontrole.model.negocio.Controle;
import br.com.infnet.appcontrole.model.repository.IControleRepository;

@Service
public class ControleService {

	@Autowired private IControleRepository repository;
	
	public void incluir(Controle controle) {
		repository.save(controle);
	}
	
	public List<Controle> obterLista(){
		return (List<Controle>)repository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public Controle obterPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public void excluir(Integer id) {
		repository.deleteById(id);
	}
}